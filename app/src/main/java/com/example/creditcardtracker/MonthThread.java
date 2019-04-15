package com.example.creditcardtracker;

import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class MonthThread extends Thread
{
    private String airportCode;
    private ArrayAdapter<String> theArrayAdapter;
    private LinkedList<String> theNonstopStrings;
    private MonthThread myContext;
    private String startDate;
    private String endDate;

    public MonthThread(String airportCode, String startDate, String endDate, ArrayAdapter<String> theArrayAdapter, LinkedList<String> theNonstopStrings)
    {
        this.airportCode = airportCode;
        this.theArrayAdapter = theArrayAdapter;
        this.theNonstopStrings = theNonstopStrings;
        this.startDate = startDate;
        this.endDate = endDate;
        this.myContext = this;
    }

    public void run()
    {
        try
        {
            URL airportURL = new URL("https://www.flightsfrom.com/" + this.airportCode + "/destinations?durationFrom=45&durationTo=315&dateMethod=month&dateFrom=" + this.startDate + "&dateTo=" + this.endDate);

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";




            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();

            System.out.println("*** HAVE DATA!!!!!");
            //System.out.println("***" + data);
            String[] parts = data.split("airport-content-destination-list-name");
            String beforeVal = "destination-search-item\">";
            String afterVal = "</span>";
            int beforeIndex, afterIndex;

            for(String part : parts)
            {
                beforeIndex = part.indexOf(beforeVal);
                if(beforeIndex != -1)
                {
                    beforeIndex += beforeVal.length();
                    afterIndex = part.indexOf(afterVal, beforeIndex);
                    //System.out.println("***" + part.substring(beforeIndex, afterIndex));
                    this.theNonstopStrings.add(part.substring(beforeIndex, afterIndex));
                }
            }
            System.out.println("***** Done");

            new Handler(Looper.getMainLooper()).post(new Runnable () {
                @Override
                public void run () {
                    myContext.theArrayAdapter.notifyDataSetChanged();
                }
            });

            //myContext.theArrayAdapter.notifyDataSetChanged();








        }
        catch(Exception e)
        {
            System.out.println("*********" + e.toString());
        }

    }
}
