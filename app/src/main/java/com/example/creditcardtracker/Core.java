package com.example.creditcardtracker;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Core
{


    public static LinkedListOfCards theCardsLL = new LinkedListOfCards();
    public static LinkedListOfLoyalty theLoyaltyLL = new LinkedListOfLoyalty();
    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;
    public static LoyaltyArrayAdapterForLinkedLists lpCustomAdapter;

    //encapsulated
    public static void addLoyaltyProgram(Loyalty lp)
    {
        Core.theLoyaltyLL.addEnd(lp);
        Core.lpCustomAdapter.notifyDataSetChanged();
    }

    public static void addCard(Card cc)
    {
        Core.theCardsLL.addEnd(cc);
        Core.ccCustomAdapter.notifyDataSetChanged();
    }

}
