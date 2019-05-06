package com.example.creditcardtracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.creditcardtracker.AirportTree.AirportTree;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.LinkedList;

public class AirportListActivity extends AppCompatActivity
{
    private ListView airportLV;
    private LinkedList<String> theAirportStrings = new LinkedList<String>();
    private LinkedList<Airport> theFilteredAirports = new LinkedList<Airport>();
    private LinkedList<Airport> theAirports = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;
    private EditText filterET;
    private AirportListActivity myContext;
    public AirportTree atree = new AirportTree();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_list);
        this.myContext = this;
        this.filterET = this.findViewById(R.id.filterET);
        this.airportLV = this.findViewById(R.id.airportLV);
        aa = new ArrayAdapter<String>(this, R.layout.another_row, this.theAirportStrings);
        this.airportLV.setAdapter(aa);


        //Used to make the list view clickable
        //this.airportLV.setClickable(true);
        this.airportLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Intent i = new Intent(myContext, AirportFlights.class);
                Airport selectedAirport = myContext.theFilteredAirports.get(position);
                i.putExtra("airportCode", selectedAirport.airportCode);
                i.putExtra("cityName", selectedAirport.city);
                i.putExtra("monthNum", "");
                i.putExtra("monthLastDay", "");
                i.putExtra("shouldCache", true);
                i.putExtra("showMonthButton", true);
                Core.currentItinerary.push(selectedAirport.city + " " + selectedAirport.airportCode);
                myContext.startActivity(i);
            }
        });


        DatabaseReference ref = Core.database.getReference("airports");
        ref.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Airport temp;
                LinkedList<String> keys = new LinkedList<String>();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //System.out.println("*********" + dataSnapshot.toString());
                    temp = ds.getValue(Airport.class);
                    atree.add(temp);
                    temp.display();
                    //temp.sanitize();        // after sanitize, comment this out.
                    theAirports.add(temp);
                    //keys.add(ds.getKey());  // after sanitize, comment this out.
                    theAirportStrings.add(temp.toString());
                }
                /*
                for(int i = 0; i < theAirports.size(); i++)
                {
                    Airport a = theAirports.get(i);
                    String key = keys.get(i);
                    if(a.isLegalCode())
                    {
                        Core.database.getReference("airports").child(key).setValue(a);
                    }
                    else
                    {
                        Core.database.getReference("airports").child(key).removeValue();
                    }
                }
                */
                //atree.visitInOrder();
                aa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

    public void onFilterButtonPressed(View v)
    {
        String filterString = this.filterET.getText().toString();
        this.theAirportStrings.clear();
        this.theFilteredAirports.clear();
        for(Airport a : this.theAirports)
        {
            if(a.filterApplies(filterString))
            {
                this.theAirportStrings.add(a.toString());
                this.theFilteredAirports.add(a);
            }
        }
        this.aa.notifyDataSetChanged();
    }

    public void onMarakaClick(View v)
    {
        Intent i = new Intent(this, AirportTreeViewActivity.class);
        Core.currTree = this.atree.getRoot();
        this.startActivity(i);
    }

}
