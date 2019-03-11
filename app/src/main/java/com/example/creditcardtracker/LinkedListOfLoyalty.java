package com.example.creditcardtracker;

public class LinkedListOfLoyalty
{
    private LoyaltyNode head;
    private int count;

    public LinkedListOfLoyalty()
    {
        this.init();
    }

    private void init()
    {
        this.head = null;
        this.count = 0;
    }

    public void removeAll()
    {
        this.init();
    }

    public int length()
    {
        return this.count;
    }

    public Loyalty getAtIndex(int index)
    {
        LoyaltyNode currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }

    public void addEnd(Loyalty payload)
    {
        LoyaltyNode n = new LoyaltyNode(payload);

        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            LoyaltyNode currNode = this.head;

            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(n);
        }
        this.count++;
    }


}
