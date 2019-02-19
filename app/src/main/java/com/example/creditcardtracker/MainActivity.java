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

    private ListView cardListView;
    private ListView loyaltyListView;
    private ArrayAdapter<String> ClistAdapter;
    private ArrayAdapter<String> LlistAdapter;
    private ArrayList<String> loyaltyArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test code below here

        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);
        Core.cardArrayList = new ArrayList<String>();
        Core.loyaltyArrayList = new ArrayList<String>();

        //three parameters 'the context, id of the layout (it will be where the data is shown), and the array that contains the data
        this.ClistAdapter = new ArrayAdapter<String>(this, R.layout.card_listview_row, Core.cardArrayList);
        this.LlistAdapter = new ArrayAdapter<String>(this, R.layout.card_listview_row, Core.loyaltyArrayList);
        this.cardListView.setAdapter(this.ClistAdapter);
        this.loyaltyListView.setAdapter(this.LlistAdapter);



    }
        //old code below
        /*this.cardListView = (ListView)this.findViewById(R.id.cardListView);

        for(int i = 0; i < Core.theCardStrings.length; i++)
        {
            Core.theCardStrings[i] = "No Card";
        }

        //Core.currCreditCard.display();
        for( int i=0; i < 5; i++)
        {
            Card c = Core.currCreditCard;
            Core.theCards[Core.numCards] = c;
            Core.theCardStrings[Core.numCards] = c.toString();
            Core.numCards++;
        }

        //Core.currCardLoyalty.display();
        for( int i=0; i < 5; i++)
        {
            Loyalty c = Core.currCardLoyalty;
            Core.theLoyalty[Core.numLoyalty] = c;
            Core.theLoyaltyStrings[Core.numLoyalty] = c.toString();
            Core.numLoyalty++;
        }



        this.listAdapter = new ArrayAdapter<String>(this, R.layout.card_listview_row, Core.theCardStrings);
        this.cardListView.setAdapter(this.listAdapter);
        */

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
