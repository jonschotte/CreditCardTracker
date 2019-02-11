package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddLoyalty extends AppCompatActivity {

    private EditText cnameET, bankaffET, curbalanceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loyalty);

        this.cnameET = (EditText)this.findViewById(R.id.cnameET);
        this.bankaffET = (EditText)this.findViewById(R.id.bankaffET);
        this.curbalanceET = (EditText)this.findViewById(R.id.curbalanceET);
    }

    public void onAddLoyaltyButtonPressed(View v)
    {
        String cname = this.cnameET.getText().toString();
        String bankaff = this.bankaffET.getText().toString();
        int curbalance = Integer.parseInt(this.curbalanceET.getText().toString());
        Loyalty c = new Loyalty(cname, bankaff, curbalance);
        c.LoyaltyDisplay();
    }
}
