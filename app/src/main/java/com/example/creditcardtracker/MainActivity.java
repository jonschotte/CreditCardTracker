package com.example.creditcardtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;





public class MainActivity extends AppCompatActivity {

    private ListView cardListView, loyaltyListView;
    private MainActivity myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.myContext = this;

        Core.database = FirebaseDatabase.getIntstance();
        Core.creditCardRef = datebase.getReference("creditCards");
        Core.loyaltyProgramRef = database.getReference("loyaltyPrograms");


        Core.loyaltyProgramRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println("****** " + dataSnapshot.toString());
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //System.out.println("********* " + dataSnapshot.toString());
                Core.theLoyaltyLL.removeAll();

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //System.out.println("********* " + ds.toString());
                    //de-serialize the card
                    System.out.println("*** Adding value");
                    Loyalty tempLP = ds.getValue(LoyaltyProgram.class);
                    tempLP.setKey(ds.getKey());
                    Core.addLoyaltyProgramLocally(tempLP);
                }
            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                System.out.println("***" + error.toString());

            }
        });

        //asynchronous call (non-blocking call) - Observer Design Pattern
        Core.creditCardRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println("****** " + dataSnapshot.toString());
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //System.out.println("********* " + dataSnapshot.toString());
                Core.theCardsLL.removeAll();

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //System.out.println("********* " + ds.toString());
                    //de-serialize the card
                    System.out.println("*** Adding value");
                    Card tempCC = ds.getValue(CreditCard.class);
                    tempCC.setKey(ds.getKey());
                    Core.addCreditCardLocally(tempCC);
                }



            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                System.out.println("***" + error.toString());

            }
        });





        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);

        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCardsLL);
        Core.lpCustomAdapter = new LoyaltyArrayAdapterForLinkedLists(this, R.layout.custom_loyalty_program_row, Core.theLoyaltyLL);

        this.cardListView.setAdapter(Core.ccCustomAdapter);
        this.loyaltyListView.setAdapter(Core.lpCustomAdapter);

        this.cardListView.setClickable(true);
        this.cardListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Card selectedCard = Core.theCardsLL.getAtIndex(position);
                Intent i = new Intent(myContext, EditCardActivity.class);
                Core.currentSelectedCard = selectedCard;
                myContext.startActivity(i);
            }
        });

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
