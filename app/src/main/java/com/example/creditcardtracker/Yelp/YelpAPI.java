package com.example.creditcardtracker.Yelp;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.creditcardtracker.AirportDestinationThread;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;


public class YelpAPI extends Thread
{

    private String cityName;
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;
    private YelpAPI myContext;


    public YelpAPI(String cityName, LinkedList<String> ll, ArrayAdapter<String> aa)
    {
        this.cityName = cityName;
        this.ll = ll;
        this.aa = aa;
        this.myContext = this;
    }

    public void run()
    {
        try
        {
            String urlString = String.format("https://api.yelp.com/v3/businesses/search?location=%, WI&categories=restaurants", this.cityName);
            URL airportURL = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "Bearer rHiHUFg_HwZTi_TYeolIb_9Z4MZxpb0PF1-OSR-mao4Amjrp1Ha0X4hotdT7QIanpjyoxs6KofAZSM0JQqLeLBUig_olxGseeWVF8heCQc8pFhaxW9Sd5fKNHgDJXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            //System.out.println("**** DATA: " + data);
            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");
            for(int i = 0; i < businesses.length(); i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                //System.out.println("**** " + name);
            }

        }
        catch (Exception e)
        {
            System.out.println("*** " + e.toString());
        }
    }
}
