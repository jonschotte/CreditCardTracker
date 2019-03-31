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
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import java.util.LinkedList;

public class AirportFlights extends AppCompatActivity {

    private ListView nonstopLV;
    private LinkedList<String> theNonstopStrings = new LinkedList<String>();
    private LinkedList<Airport> theNonstop = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;
    private AirportFlights myContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_flights);
        TextView airportTV = (TextView)this.findViewById(R.id.SelectedAirportTV);
        this.nonstopLV = this.findViewById(R.id.nonstopLV);
        this.myContext = this;

        LinkedList<String> ll = new LinkedList<String>();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.nonstopLV.setAdapter(aa);

        String airportCode = this.getIntent().getStringExtra("airportCode");

        //strip the " from both ends of the airport code
        airportCode = airportCode.replaceAll("\"","");

        airportTV.setText(airportCode);


        NetworkThread nt = new NetworkThread(airportCode, aa, ll);
        nt.setPriority(Thread.MAX_PRIORITY);
        nt.start();

        this.nonstopLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Intent i = new Intent(myContext, AirportFlights.class);
                //Airport selectedAirport = myContext.theNonstop.get(position);
                String selectedAirport = (String)myContext.nonstopLV.getItemAtPosition(position);
                System.out.println("*********" + selectedAirport);
                //need to set airportCode to last 3 char of string

                //i.putExtra("airportCode", selectedAirport.airportCode);
                myContext.startActivity(i);
            }
        });





    }
}
