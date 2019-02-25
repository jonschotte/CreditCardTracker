package com.example.creditcardtracker;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Core
{
    /*
    public static int numCards = 0;
    public static Card[] theCards = new Card[10];
    public static String[] theCardStrings = new String[10];
    public static Card currCreditCard = null;

    public static int numLoyalty = 0;
    public static Loyalty[] theLoyalty = new Loyalty[10];
    public static String[] theLoyaltyStrings = new String[10];
    public static Loyalty currCardLoyalty = null;


    public static ArrayList<String> cardArrayList;
    public static ArrayList<String> loyaltyArrayList;
     */

    public static LinkedListOfCards theCardsLL = new LinkedListOfCards();
    public static LinkedListOfLoyalty theLoyaltyLL = new LinkedListOfLoyalty();
    public static Card[] theCards = new Card[1000];
    public static Loyalty[] theLoyaltyPrograms = new Loyalty[1000];
    public static String[] theCardStrings = new String[1000];
    public static String[] theLoyaltyProgramStrings = new String[1000];
    public static int numCards = 0;
    public static int numLoyalty = 0;
    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;
    public static LoyaltyArrayAdapterForLinkedLists lpCustomAdapter;

    //encapsulated
    public static void addLoyaltyProgram(Loyalty lp)
    {
        //happens in a static context
        Core.theLoyaltyLL.addEnd(lp);
        Core.theLoyaltyPrograms[Core.numLoyalty] = lp;
        Core.theLoyaltyProgramStrings[Core.numLoyalty] = lp.toString();
        Core.numLoyalty++;
        Core.lpCustomAdapter.notifyDataSetChanged();
    }

    public static void addCard(Card cc)
    {
        Core.theCardsLL.addEnd(cc);
        Core.theCards[Core.numCards] = cc;
        Core.theCardStrings[Core.numCards] = cc.toString();
        Core.numCards++;
        Core.ccCustomAdapter.notifyDataSetChanged();
    }

}
