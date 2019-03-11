package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditCardActivity extends AppCompatActivity
{

    private EditText creditCardNameET, creditCardStartDateET,
            creditCardMinSpendET, creditCardBonusPointET;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        this.creditCardNameET = (EditText)this.findViewById(R.id.creditCardNameET);
        this.creditCardStartDateET = (EditText)this.findViewById(R.id.creditCardStartDate);
        this.creditCardMinSpendET = (EditText)this.findViewById(R.id.creditCardMinSpendET);
        this.creditCardBonusPointET = (EditText)this.findViewById(R.id.creditCardBonusPointsET);

        this.creditCardNameET.setText(Core.currentSelectedCard.name);
        this.creditCardBonusPointET.setText(Core.currentSelectedCard.point_bonus + "");
        this.creditCardMinSpendET.setText(Core.currentSelectedCard.min_spend + "");
        this.creditCardStartDateET.setText(Core.currentSelectedCard.start_date);
    }

    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedCard.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        String CardName = this.creditCardNameET.getText().toString();
        String CardStartDate = this.creditCardStartDateET.getText().toString();
        int CardMinSpend = Integer.parseInt(this.creditCardMinSpendET.getText().toString());
        int CardBonusPoints = Integer.parseInt(this.creditCardBonusPointET.getText().toString());

    }
}
