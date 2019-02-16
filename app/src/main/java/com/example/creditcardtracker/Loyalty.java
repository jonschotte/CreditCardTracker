package com.example.creditcardtracker;

public class Loyalty
{
    private String cname;
    private String bankaff;
    private int pointbalance;

    public Loyalty (String cname, String bankaff)
    {
        this.cname = cname;
        this.bankaff = bankaff;
        this.pointbalance = 0;
    }

    public Loyalty (String cname, String bankaff, int pointbalance)
    {
        this(cname, bankaff);
        this.pointbalance = pointbalance;
    }

    public void display()
    {
        System.out.println("Name: " + this.cname);
        System.out.println("Bank Affiliation: " + this.bankaff);
        System.out.println("Point Balance: " + this.pointbalance);
    }
}
