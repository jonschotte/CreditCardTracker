package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView cardListView, loyaltyListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList ll = new LinkedList();
        for(int i = 0; i < 10; i++)
        {
            ll.addEnd(i);
        }

        for(int i = 0; i < ll.length(); i++)
        {
            System.out.println("LL: " + ll.getAtIndex(i));
        }

        for(int i = 0; i < 1000; i++)
        {
            Core.theLoyaltyProgramStrings[i] = "N/A";
            Core.theCardStrings[i] = "N/A";
            Core.theCards[i] = new Card();
        }






        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);

        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCardsLL);
        Core.lpCustomAdapter = new LoyaltyArrayAdapterForLinkedLists(this, R.layout.custom_loyalty_program_row, Core.theLoyaltyLL);
        //Core.lpCustomAdapter = new ArrayAdapter(this, R.layout.custom_loyalty_program_row, Core.theCreditCardsLL);

        this.cardListView.setAdapter(Core.ccCustomAdapter);
        this.loyaltyListView.setAdapter(Core.lpCustomAdapter);
       // this.loyaltyListView.setAdapter(this.lpAdapter);

    }


    public void onCardButtonPressed(View v)
    {
        //intent used to go to other page
        Intent i = new Intent(this, AddCard.class);
        this.startActivity(i);
    }

    public void onLoyaltyButtonPressed(View v)
    {
        //intent used to go to other page
        Intent i = new Intent(this, AddLoyalty.class);
        this.startActivity(i);
    }
}
