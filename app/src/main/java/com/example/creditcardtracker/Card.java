package com.example.creditcardtracker;

public class Card
{
    private String cname;
    private String startdate;
    private int minspend;
    private int rewardpoints;

    public Card (String cname, String startdate, int minspend, int rewardpoints)
    {
        this.cname = cname;
        this.startdate = startdate;
        this.minspend = minspend;
        this.rewardpoints = rewardpoints;
    }

    public void display()
    {
        System.out.println("Name: " + this.cname);
        System.out.println("Start Date: " + this.startdate);
        System.out.println("Minimum Spend: " + this.minspend);
        System.out.println("Reward Points: " + this.rewardpoints);
    }

    public String toString()
    {
        return this.cname + " " + this.startdate + " $" + this.minspend + " " + this.rewardpoints;

    }
}
