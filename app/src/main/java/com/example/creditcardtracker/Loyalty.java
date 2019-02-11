package com.example.creditcardtracker;

public class Loyalty
{
    private String cname;
    private String bankaff;
    private int curbalance;

    public Loyalty (String cname, String bankaff, int curbalance)
    {
        this.cname = cname;
        this.bankaff = bankaff;
        this.curbalance = curbalance;
    }

    public void LoyaltyDisplay()
    {
        System.out.println("Name: " + this.cname);
        System.out.println("Bank Affiliation: " + this.bankaff);
        System.out.println("Current Balance: " + this.curbalance);
    }
}
