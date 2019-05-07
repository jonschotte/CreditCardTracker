package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.creditcardtracker.Yelp.YelpAPI;

import java.util.LinkedList;

public class RestaurantListActivity extends AppCompatActivity {

    private ListView RestaurantListView;
    private TextView LocationTV;
    private RestaurantListActivity myContext;
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;
    private String cityName;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        this.myContext = this;
        cityName = getIntent().getStringExtra("Location");
        //System.out.println("*******" + cityName );
        YelpAPI yelp = new YelpAPI(cityName, ll, aa);
        yelp.start();




        LocationTV = this.findViewById(R.id.LocationTV);
        this.RestaurantListView = this.findViewById(R.id.RestaurantListView);




        cityName = getIntent().getStringExtra("Location");
        this.LocationTV.setText(cityName);

        this.ll = new LinkedList<String>();
        this.aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.RestaurantListView.setAdapter(aa);

        this.RestaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                String selectedAirport = ll.get(position).trim();
                String[] parts = selectedAirport.split(" ");

                Intent i = new Intent(myContext, RestaurantListActivity.class);
                i.putExtra("airportCode", parts[parts.length-1].trim());
                String cityName = "";
                for(int j = 0; j < parts.length-1; j++)
                {
                    cityName = cityName + parts[j] + " ";
                }
                i.putExtra("cityName", cityName);
                myContext.startActivity(i);
            }
        });










    }
}
