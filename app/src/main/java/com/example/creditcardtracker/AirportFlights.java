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
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;
    private AirportCodeCache acc;
    private AirportFlights myContext;


/*
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

        Core.airportCode = this.getIntent().getStringExtra("airportCode");
        String airportCode = Core.airportCode;
        System.out.println("this is it" + airportCode);
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
                //String selectedAirport = (String)myContext.nonstopLV.getItemAtPosition(position);
                //need to set airportCode to last 3 char of string
                String CityandAirportCodeString = (String)myContext.nonstopLV.getItemAtPosition(position);
                String airportCode = CityandAirportCodeString.substring(CityandAirportCodeString.length() - 3);
                //Airport selectedAirport = new Airport();
                //selectedAirport.airportCode = AirportCodeString;
                System.out.println("*********" + airportCode);
                i.putExtra("airportCode", airportCode);
                myContext.startActivity(i);
            }
        });





    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.myContext = this;
        setContentView(R.layout.activity_airport_flights);
        final TextView airportTV = this.findViewById(R.id.SelectedAirportTV);
        this.nonstopLV = this.findViewById(R.id.nonstopLV);

        this.ll = new LinkedList<String>();
        this.aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.nonstopLV.setAdapter(aa);

        this.nonstopLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                String selectedAirport = ll.get(position).trim();
                String[] parts = selectedAirport.split(" ");

                Intent i = new Intent(myContext, AirportFlights.class);
                i.putExtra("airportCode", parts[parts.length-1].trim());
                String cityName = "";
                for(int j = 0; j < parts.length-1; j++)
                {
                    cityName = cityName + parts[j] + " ";
                }
                i.putExtra("cityName", cityName);
                Core.currentItinerary.push(cityName + " " + parts[parts.length-1].trim());
                Core.currentItineraryLL.add(cityName + " " + parts[parts.length-1].trim());
                myContext.startActivity(i);
            }
        });


        String cityName = this.getIntent().getStringExtra("cityName");
        String airportCode = this.getIntent().getStringExtra("airportCode");
        airportCode = airportCode.replaceAll("\"","");
        airportTV.setText(cityName + " - " + airportCode);

        System.out.println("*** " + airportCode);
        this.acc = new AirportCodeCache(airportCode);
        acc.getData(aa, ll);


    }

    public void onDisplayItineraryButtonPressed(View v)
    {
        Core.currentItinerary.display();
        Intent i = new Intent(this, ItineraryList.class);
        this.startActivity(i);
    }

    @Override
    public void onBackPressed()
    {
        Core.currentItinerary.pop();
        super.onBackPressed();
    }

    public void onReloadCacheButtonPressed(View v)
    {
        this.acc.clearCache(this.aa, this.ll);
    }

    public void onMonthButtonPressed(View v)
    {
        //intent used to go to other page
        Intent i = new Intent(this, MonthList.class);
        this.startActivity(i);




    }

}
