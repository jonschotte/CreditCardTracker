package com.example.creditcardtracker;

public class Card
{
    private String fname;
    private String lname;
    private String startdate;
    private int minspend;
    private int rewardpoints;

    public Card (String fname, String lname, String startdate, int minspend, int rewardpoints)
    {
        this.fname = fname;
        this.lname = lname;
        this.startdate = startdate;
        this.minspend = minspend;
        this.rewardpoints = rewardpoints;
    }

    public void CardDisplay()
    {
        System.out.println("Name: " + this.fname + " " + this.lname);
        System.out.println("Start Date: " + this.startdate);
        System.out.println("Minimum Spend: " + this.minspend);
        System.out.println("Reward Points: " + this.rewardpoints);
    }
}
