package com.example.creditcardtracker;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class  Loyalty implements Serializable
{
    public String name;
    public String bankaff;
    public int pointbalance;
    private String key;
    private DatabaseReference ref;


    public Loyalty (String name, String bankaff, int pointbalance)
    {
        this.name = name;
        this.bankaff = bankaff;
        this.pointbalance = pointbalance;
    }

    public Loyalty ()
    {

    }

    public void setKey(String key)
    {
        this.key = key;
        this.ref = Core.loyaltyProgramRef.child(this.key);
    }

    public void save()
    {
        this.ref.setValue(this);
    }

    public void delete()
    {
        this.ref.removeValue();
    }


    public void display()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Bank Affiliation: " + this.bankaff);
        System.out.println("Point Balance: " + this.pointbalance);
    }

    public String toString()
    {
        return "Card Name: " + this.name + " - Bank Affiliation: "
                + this.bankaff + " - Point Balance: " + this.pointbalance;

    }
}
