package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class ItineraryList extends AppCompatActivity {

    private ListView ItineraryLV;
    private ItineraryList myContext;
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        this.myContext = this;
        this.ItineraryLV = this.findViewById(R.id.ItineraryLV);
        this.ll = new LinkedList<String>();
        this.aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.ItineraryLV.setAdapter(aa);

    }
}
