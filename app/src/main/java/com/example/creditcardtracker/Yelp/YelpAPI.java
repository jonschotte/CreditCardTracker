package com.example.creditcardtracker.Yelp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class YelpAPI extends Thread
{
    public void run()
    {
        try
        {
            URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=Milwaukee, WI&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "Bearer rHiHUFg_HwZTi_TYeolIb_9Z4MZxpb0PF1-OSR-mao4Amjrp1Ha0X4hotdT7QIanpjyoxs6KofAZSM0JQqLeLBUig_olxGseeWVF8heCQc8pFhaxW9Sd5fKNHgDJXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("**** DATA: " + data);
            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");
            for(int i = 0; i < businesses.length(); i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                System.out.println("**** " + name);
            }

        }
        catch (Exception e)
        {
            System.out.println("*** " + e.toString());
        }
    }
}
