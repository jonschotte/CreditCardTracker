package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class AirportFlightsOther extends AppCompatActivity {

    private ListView nonstopOtherLV;
    //private LinkedList<String> theNonstopStrings = new LinkedList<String>();
    //private LinkedList<Airport> theNonstop = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;
    private AirportFlightsOther myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_flights_other);

        TextView airportTV = (TextView)this.findViewById(R.id.SelectedAirportTV);
        this.nonstopOtherLV = this.findViewById(R.id.nonstopOtherLV);
        this.myContext = this;

        LinkedList<String> ll = new LinkedList<String>();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.nonstopOtherLV.setAdapter(aa);

        String airportCode = Core.airportCode;
        System.out.println("this is it" + airportCode);
        //strip the " from both ends of the airport code
        //airportCode = airportCode.replaceAll("\"","");

        airportTV.setText(airportCode);



        NetworkThread nt = new NetworkThread(airportCode, aa, ll);
        nt.setPriority(Thread.MAX_PRIORITY);
        nt.start();

        this.nonstopOtherLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {

                Intent i = new Intent(myContext, AirportFlightsOther.class);
                //Airport selectedAirport = myContext.theNonstop.get(position);
                //String selectedAirport = (String)myContext.nonstopLV.getItemAtPosition(position);
                //need to set airportCode to last 3 char of string
                String CityandAirportCodeString = (String)myContext.nonstopOtherLV.getItemAtPosition(position);
                Core.airportCode = CityandAirportCodeString.substring(CityandAirportCodeString.length() - 3);

                //Airport selectedAirport = new Airport();
                //selectedAirport.airportCode = AirportCodeString;
                //System.out.println("*********" + selectedAirport.airportCode);

                //i.putExtra("airportCode", selectedAirport.airportCode);
                finish();
                startActivity(getIntent());
            }
        });
    }
}
