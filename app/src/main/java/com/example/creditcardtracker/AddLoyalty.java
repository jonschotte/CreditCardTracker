package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class  AddLoyalty extends AppCompatActivity {

    private EditText nameET, bankaffET, pointbalanceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loyalty);

        this.nameET = (EditText)this.findViewById(R.id.cnameET);
        this.bankaffET = (EditText)this.findViewById(R.id.bankaffET);
        this.pointbalanceET = (EditText)this.findViewById(R.id.pointbalanceET);
    }

    public void onAddLoyaltyButtonPressed(View v)
    {
        String name = this.nameET.getText().toString();
        String bankaff = this.bankaffET.getText().toString();
        int pointbalance = Integer.parseInt(this.pointbalanceET.getText().toString());
        Loyalty lp = new Loyalty(name, bankaff, pointbalance);
        lp.display();
        Core.addLoyaltyProgramLocally(lp);
        finish();
    }
}
