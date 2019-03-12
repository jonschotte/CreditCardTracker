package com.example.creditcardtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditCardActivity extends AppCompatActivity
{

    private EditText cnameET, startdateET, minspendET, rewpointsET;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        this.cnameET = (EditText)this.findViewById(R.id.cnameET);
        this.startdateET = (EditText)this.findViewById(R.id.startdateET);
        this.minspendET = (EditText)this.findViewById(R.id.minspendET);
        this.rewpointsET = (EditText)this.findViewById(R.id.rewpointsET);

        this.cnameET.setText(Core.currentSelectedCard.name);
        this.rewpointsET.setText(Core.currentSelectedCard.point_bonus + "");
        this.minspendET.setText(Core.currentSelectedCard.min_spend + "");
        this.startdateET.setText(Core.currentSelectedCard.start_date);
    }

    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedCard.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        String cname = this.cnameET.getText().toString();
        String startdate = this.startdateET.getText().toString();
        int minspend = Integer.parseInt(this.minspendET.getText().toString());
        int rewardpoints = Integer.parseInt(this.rewpointsET.getText().toString());
        Core.currentSelectedCard.name = cname;
        Core.currentSelectedCard.start_date = startdate;
        Core.currentSelectedCard.min_spend = minspend;
        Core.currentSelectedCard.point_bonus = rewardpoints;
        Core.currentSelectedCard.save();
        this.finish();
    }
}
