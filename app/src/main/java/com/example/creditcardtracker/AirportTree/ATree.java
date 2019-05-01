package com.example.creditcardtracker.AirportTree;

import com.example.creditcardtracker.Airport;

import java.io.Serializable;

public class ATree implements Serializable
{
    public Airport payload;
    public ATree left;
    public ATree right;

    public ATree(Airport payload)
    {
        this.payload = payload;
        this.left = null;
        this.right = null;
    }

    public String visitInOrder()
    {
        String answer = "";
        if (this.left!= null)
        {
            answer += this.left.visitInOrder();
        }
        answer += "  " + this.left.visitInOrder();
        if (this.right != null)
        {
            answer += this.right.visitInOrder();
        }
        return answer;
    }

    public void add(ATree a)
    {
        if(this.payload.airportCode.compareTo(a.payload.airportCode) <= 0)
        {
            if(this.right == null)
            {
                this.right =a;
            }
            else
            {
                this.right.add(a);
            }
        }
        else
        {
            if(this.left == null)
            {
                this.left =a;
            }
            else
            {
                this.left.add(a);
            }
        }
    }
}
