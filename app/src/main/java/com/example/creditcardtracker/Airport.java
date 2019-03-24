package com.example.creditcardtracker;

import com.google.android.gms.common.api.internal.StatusExceptionMapper;

import java.io.Serializable;

public class Airport implements Serializable
{
    public String name;
    public String country;
    public String region;
    public String city;
    public String airportCode;

    public Airport (String name, String country, String region, String city, String airportCode)
    {
        this.name = name;
        this.country = country;
        this.region = region;
        this.city = city;
        this.airportCode = airportCode;
    }

    public Airport()
    {

    }

    //public String toString()
    {

    }



    public void display()
    {
        System.out.println("***" + this.name + this.country + this.region + this.city + this.airportCode);
    }
}
