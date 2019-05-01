package com.example.creditcardtracker.Yelp;

import java.net.HttpURLConnection;
import java.net.URL;


public class YelpAPI extends Thread
{
    public void run()
    {
        try
        {
            URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=Milwaukee, WI&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "Bearer rHiHUFg_HwZTi_TYeolIb_9Z4MZxpb0PF1-OSR-mao4Amjrp1Ha0X4hotdT7QIanpjyoxs6KofAZSM0JQqLeLBUig_olxGseeWVF8heCQc8pFhaxW9Sd5fKNHgDJXHYx");
        }
        catch (Exception e)
        {

        }
    }
}
