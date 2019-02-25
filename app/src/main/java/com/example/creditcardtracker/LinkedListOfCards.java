package com.example.creditcardtracker;

public class LinkedListOfCards
{
    private CardNode head;
    private int count;

    public LinkedListOfCards()
    {
        this.head = null;
        this.count = 0;
    }

    public int length()
    {
        return this.count;
    }

    public Card getAtIndex(int index)
    {
        CardNode currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }

    public void addEnd(Card payload)
    {
        CardNode n = new CardNode(payload);

        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            CardNode currNode = this.head;

            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            currNode.setNextNode(n);
        }
        this.count++;
    }
}
