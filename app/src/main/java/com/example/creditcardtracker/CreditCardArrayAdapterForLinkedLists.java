package com.example.creditcardtracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CreditCardArrayAdapterForLinkedLists extends ArrayAdapter
{
    private Context mContext;
    private LinkedListOfCards CardList;
    private int textViewResourceId;

    public CreditCardArrayAdapterForLinkedLists(Context context, int textViewResourceId,
                                                LinkedListOfCards list)
    {
        super(context, textViewResourceId); //Super sets the parents context for array adapter
        this.mContext = context; //can use the super getcontext function to pull from the parent
        this.CardList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public int getCount()
    {
        return this.CardList.length();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        TextView ccName = (TextView)listItem.findViewById(R.id.ccNameTV);
        TextView ccStartDate = (TextView)listItem.findViewById(R.id.ccStartDateTV);
        TextView ccMinSpend = (TextView)listItem.findViewById(R.id.ccMinSpendTV);
        TextView ccBonusPoints = (TextView)listItem.findViewById(R.id.ccBonusPointsTV);
        Card cc = this.CardList.getAtIndex(position);

        ccName.setText(cc.getName());
        ccStartDate.setText(cc.getStart_date());
        ccMinSpend.setText("" + cc.getMin_spend());
        ccBonusPoints.setText("" + cc.getPoint_bonus());
        //return the View after we have set all of the values
        return listItem;
    }
}
