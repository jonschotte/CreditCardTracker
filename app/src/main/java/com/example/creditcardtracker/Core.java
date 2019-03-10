package com.example.creditcardtracker;

import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Core
{


    public static LinkedListOfCards theCardsLL = new LinkedListOfCards();
    public static LinkedListOfLoyalty theLoyaltyLL = new LinkedListOfLoyalty();
    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;
    public static LoyaltyArrayAdapterForLinkedLists lpCustomAdapter;
    public static FirebaseDatabase database; //
    public static DatabaseReference myRef;

    //encapsulated
    public static void addLoyaltyProgram(Loyalty lp)
    {
        Core.theLoyaltyLL.addEnd(lp);
        Core.lpCustomAdapter.notifyDataSetChanged();
    }

    public static void addCardtoFirebase(Card cc) //firebase
    {
        Core.theCardsLL.addEnd(cc);
        Core.ccCustomAdapter.notifyDataSetChanged();
    }

    public static void addCardLocally(Card cc)
    {
        Core.theCardsLL.addEnd(cc);
        Core.ccCustomAdapter.notifyDataSetChanged();
    }

}
