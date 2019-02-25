package com.example.creditcardtracker;

public class  Loyalty
{
    private String name;
    private String bankaff;
    private int pointbalance;



    public Loyalty (String name, String bankaff, int pointbalance)
    {
        this.name = name;
        this.bankaff = bankaff;
        this.pointbalance = pointbalance;
    }

    public Loyalty ()
    {
        this.name = "Name";
        this.bankaff = "Bank Affiliation";
        this.pointbalance = -1;
    }

    public String getName() {return name;}

    public String getBankaff() {return bankaff;}

    public int getBalance() {return pointbalance;}

    public void display()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Bank Affiliation: " + this.bankaff);
        System.out.println("Point Balance: " + this.pointbalance);
    }

    public String toString()
    {
        return "Card Name: " + this.name + " - Bank Affiliation: " + this.bankaff + " - Point Balance: " + this.pointbalance;

    }
}
