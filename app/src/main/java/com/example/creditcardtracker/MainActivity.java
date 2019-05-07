package com.example.creditcardtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.creditcardtracker.Yelp.YelpAPI;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import static com.example.creditcardtracker.Core.database;


public class MainActivity extends AppCompatActivity {

    private ListView cardListView, loyaltyListView;
    private MainActivity myContext;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        com.example.creditcardtracker.BinaryTree bt = new com.example.creditcardtracker.BinaryTree();
        bt.addValue(5);
        bt.addValue(2);
        bt.addValue(1);
        bt.addValue(7);
        bt.addValue(8);
        bt.addValue(3);
        bt.visitInOrder();
        bt.visitPostOrder();
        bt.visitPreOrder();

        String obj1 = "MKE";
        String obj2 = "ATL";
        String obj3 = new String("atl");

        System.out.println("*** LOL" + obj2.compareTo(obj3));



        //USE TO CLEAR DATABASE
        //DatabaseReference root = FirebaseDatabase.getInstance().getReference();
        //root.setValue(null);

        this.myContext = this;

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

        this.loyaltyListView.setClickable(true);
        this.loyaltyListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Loyalty selectedLoyalty = Core.theLoyaltyLL.getAtIndex(position);
                Intent i = new Intent(myContext, EditLoyaltyActivity.class);
                Core.currentSelectedLoyalty = selectedLoyalty;
                myContext.startActivity(i);
            }
        });

        Core.database = FirebaseDatabase.getInstance();
        Core.creditCardRef = database.getReference("creditCards");
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
                    Loyalty tempLP = ds.getValue(Loyalty.class);
                    tempLP.setKey(ds.getKey());
                    Core.addLoyaltyProgramLocally(tempLP);
                }
                Core.lpCustomAdapter.notifyDataSetChanged();
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
                    Card tempCC = ds.getValue(Card.class);
                    tempCC.setKey(ds.getKey());
                    Core.addCardLocally(tempCC);
                }
                Core.ccCustomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                System.out.println("***" + error.toString());

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

    public void onAirportlistButtonPressed(View v)
    {
        //intent used to go to other page
        Intent i = new Intent(this, AirportListActivity.class);
        this.startActivity(i);
    }



}
