package com.example.creditcardtracker;

public class LoyaltyNode
{
    private Loyalty payload;
    private LoyaltyNode nextNode;

    public LoyaltyNode(Loyalty payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public void setNextNode(LoyaltyNode nextNode)
    {
        this.nextNode = nextNode;
    }

    public Loyalty getPayload()
    {
        return payload;
    }

    public LoyaltyNode getNextNode()
    {
        return nextNode;
    }
}
