package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditLoyaltyActivity extends AppCompatActivity
{

    private EditText nameET, bankaffET, pointbalanceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_loyalty);

        this.nameET = (EditText)this.findViewById(R.id.cnameET);
        this.bankaffET = (EditText)this.findViewById(R.id.bankaffET);
        this.pointbalanceET = (EditText)this.findViewById(R.id.pointbalanceET);

        this.nameET.setText(Core.currentSelectedLoyalty.name);
        this.bankaffET.setText(Core.currentSelectedLoyalty.bankaff);
        this.pointbalanceET.setText(Core.currentSelectedLoyalty.pointbalance + "");

    }
    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedLoyalty.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        String name = this.nameET.getText().toString();
        String bankaff = this.bankaffET.getText().toString();
        int pointbalance = Integer.parseInt(this.pointbalanceET.getText().toString());
        Core.currentSelectedLoyalty.save();
        this.finish();
    }
}
