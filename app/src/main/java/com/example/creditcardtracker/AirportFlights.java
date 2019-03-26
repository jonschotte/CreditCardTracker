package com.example.creditcardtracker;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import java.util.LinkedList;

public class AirportFlights extends AppCompatActivity {

    private ListView nonstopLV;
    private LinkedList<String> theNonstopStrings = new LinkedList<String>();
    private LinkedList<Airport> theNonstop = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_flights);

        String theAirport = ("Nonstop flights from" + Core.currentSelectedAirport);
        TextView airport = (TextView)this.findViewById(R.id.SelectedAirportTV);
        airport.setText(theAirport);
        System.out.println("*******Code" +  Core.currentSelectedAirportCode);

        NetworkThread nt = new NetworkThread("MKE");
        nt.start();


        this.nonstopLV = this.findViewById(R.id.nonstopLV);
        aa = new ArrayAdapter<String>(this, R.layout.another_row, this.theNonstopStrings);
        this.nonstopLV.setAdapter(aa);





    }
}
