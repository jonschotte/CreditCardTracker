package com.example.creditcardtracker;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Struct;

public class Core
{

    public static LinkedListOfCards theCardsLL = new LinkedListOfCards();
    public static LinkedListOfLoyalty theLoyaltyLL = new LinkedListOfLoyalty();
    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;
    public static LoyaltyArrayAdapterForLinkedLists lpCustomAdapter;
    public static FirebaseDatabase database;
    public static DatabaseReference creditCardRef;
    public static DatabaseReference loyaltyProgramRef;
    public static Card currentSelectedCard = null;
    public static Loyalty currentSelectedLoyalty = null;
    public static ItineraryStack currentItinerary = new ItineraryStack();

    //encapsulated
    public static void addLoyaltyProgramLocally(Loyalty lp)
    {
        Core.theLoyaltyLL.addEnd(lp);
        Core.lpCustomAdapter.notifyDataSetChanged();
    }

    public static void addLoyaltyProgramToFirebase(Loyalty lp)
    {
        Core.loyaltyProgramRef.push().setValue(lp);
    }


    public static void addCardLocally(Card cc)
    {
        Core.theCardsLL.addEnd(cc);
        Core.ccCustomAdapter.notifyDataSetChanged();
    }

    public static void addCardToFirebase(Card cc)
    {
        Core.creditCardRef.push().setValue(cc);
    }
}
