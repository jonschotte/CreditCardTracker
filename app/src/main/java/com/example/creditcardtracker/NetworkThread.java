package com.example.creditcardtracker;

import com.google.firebase.database.DatabaseReference;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkThread extends Thread
{
    private String airportCode;

    public NetworkThread(String airportCode)
    {
        this.airportCode = airportCode;
    }



    public void run()
    {
         /*
        try
        {



            //URL airportURL = new URL("http://ourairports.com/data/airports.csv");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";


            java.util.LinkedList<Airport> ll = new java.util.LinkedList<Airport>();
            DatabaseReference ref = Core.database.getReference("airports");
            Airport temp;

            while(input.hasNextLine())
            {
                String[] parts = input.nextLine().split(",");
                if (parts.length >= 14)
                {
                    temp = new Airport(parts[3], parts[8], parts[9], parts[10], parts[13]);
                    if(temp.airportCode.length()>0)
                    {
                        ll.add(temp);
                    }
                }


            }
            System.out.println("********" + ll.size());
            ref.setValue(ll);

            System.out.println("****** DONE");
        }
        */

        try
        {
            URL airportURL = new URL("https://www.flightsfrom.com/" + Core.currentSelectedAirportCode + "/destinations");

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            System.out.println("***" + data);
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
                }
            }
            System.out.println("***** Done");

        }
        catch(Exception e)
        {
            System.out.println("*********" + e.toString());
        }

    }
}
