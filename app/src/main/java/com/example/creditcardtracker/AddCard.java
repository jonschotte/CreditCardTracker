package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCard extends AppCompatActivity {

    private EditText fnameET, lnameET, startdateET, minspendET, rewpointsET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        this.fnameET = (EditText)this.findViewById(R.id.fnameET);
        this.lnameET = (EditText)this.findViewById(R.id.lnameET);
        this.startdateET = (EditText)this.findViewById(R.id.startdateET);
        this.minspendET = (EditText)this.findViewById(R.id.minspendET);
        this.rewpointsET = (EditText)this.findViewById(R.id.rewpointsET);
    }

    public void onAddCardButtonPressed(View v)
    {
        String fname = this.fnameET.getText().toString();
        String lname = this.lnameET.getText().toString();
        String startdate = this.startdateET.getText().toString();
        int minspend = Integer.parseInt(this.minspendET.getText().toString());
        int rewardpoints = Integer.parseInt(this.rewpointsET.getText().toString());
        Card c = new Card(fname, lname, startdate, minspend, rewardpoints);
        c.CardDisplay();
    }


}
