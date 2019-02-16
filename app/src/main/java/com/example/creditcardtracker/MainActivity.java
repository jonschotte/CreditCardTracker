package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView cardListView;
    private ListView loyaltyListView;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test code below here


        this.cardListView = (ListView)this.findViewById(R.id.cardListView);

        for(int i = 0; i < Core.theCardStrings.length; i++)
        {
            Core.theCardStrings[i] = "No Card";
        }
        Core.currCreditCard.display();
        for( int i=0; i < 5; i++)
        {
            Card c = Core.currCreditCard;
            Core.theCards[Core.numCards] = c;
            Core.theCardStrings[Core.numCards] = c.toString();
            Core.numCards++;
        }


        this.listAdapter = new ArrayAdapter<String>(this, R.layout.card_listview_row, Core.theCardStrings);
        this.cardListView.setAdapter(this.listAdapter);


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
