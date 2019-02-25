package com.example.creditcardtracker;

public class CardNode
{
    private Card payload;
    private CardNode nextNode;

    public CardNode(Card payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public void setNextNode(CardNode nextNode) {
        this.nextNode = nextNode;
    }

    public Card getPayload() {
        return payload;
    }

    public CardNode getNextNode() {
        return nextNode;
    }
}
