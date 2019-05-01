package com.example.creditcardtracker.AirportTree;

import com.example.creditcardtracker.Airport;

public class AirportTree {
    private ATree root;

    public AirportTree()
    {
        this.root = null;
    }

    public ATree getRoot() {
        return root;
    }

    public void add(Airport payload)
    {
        ATree a = new ATree(payload);
        if(this.root == null)
        {
            this.root = a;
        }
        else
        {
            this.root.add(a);
        }
    }

    public void visitInOrder()
    {
        System.out.println("*******airports: " + this.root.visitInOrder());
    }
}
