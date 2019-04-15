package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class ItineraryList extends AppCompatActivity {

    private ListView itineraryLV;
    private ItineraryList myContext;
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        ListView itineraryLV = this.findViewById(R.id.itineraryLV);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.another_row, Core.currentItinerary.getAsList());
        itineraryLV.setAdapter(aa);

    }
}
