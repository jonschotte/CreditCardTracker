package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private ListView cardListView, loyaltyListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Core.database = FirebaseDatabase.getInstance(); //
        Core.myRef = Core.database.getReference("Credit Cards");
        Core.myRef = Core.database.getReference("Loyalty Programs");


        // *********Write a message to the database************

        //DatabaseReference myRef2 = database.getReference("products");

        //Card cc = new Card("Chase", "1/1/1111", 1000, 2000);
        //myRef.push().setValue(cc);
        //myRef2.setValue("LOL");
        //myRef.push().setValue("Hello, World!");
        //myRef2.push().setValue("LOL");
        //myRef2.child("woot").push().setValue("LOL");

        // *******Read from the database**********
        //asynchronous call (non-blocking call) - Observer Design Pattern
        Core.myRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    System.out.println(" ADDING NEW VALUE *******");
                    Card tempCC = ds.getValue(Card.class);
                    Core.addCardLocally(tempCC);
                }
                //DataSnapshot theCards = (DataSnapshot)dataSnapshot.getValue();
                //System.out.println("************"+ dataSnapshot.toString());
                //System.out.println("************"+ theCards.toString());

            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
            }
        }
        );



        //
        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);

        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCardsLL);
        Core.lpCustomAdapter = new LoyaltyArrayAdapterForLinkedLists(this, R.layout.custom_loyalty_program_row, Core.theLoyaltyLL);

        this.cardListView.setAdapter(Core.ccCustomAdapter);
        this.loyaltyListView.setAdapter(Core.lpCustomAdapter);

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
