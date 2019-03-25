package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCard extends AppCompatActivity {

    private EditText cnameET, startdateET, minspendET, rewpointsET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        this.cnameET = (EditText)this.findViewById(R.id.cnameET);
        this.startdateET = (EditText)this.findViewById(R.id.startdateET);
        this.minspendET = (EditText)this.findViewById(R.id.minspendET);
        this.rewpointsET = (EditText)this.findViewById(R.id.rewpointsET);
    }

    public void onAddCardButtonPressed(View v)
    {
        String cname = this.cnameET.getText().toString();
        String startdate = this.startdateET.getText().toString();
        int minspend = Integer.parseInt(this.minspendET.getText().toString());
        int rewardpoints = Integer.parseInt(this.rewpointsET.getText().toString());
        Card cc = new Card(cname, startdate, minspend, rewardpoints);

        cc.display();
        Core.addCardToFirebase(cc);
        this.finish();
    }

}
