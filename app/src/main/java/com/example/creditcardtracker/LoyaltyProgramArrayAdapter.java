package com.example.creditcardtracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LoyaltyProgramArrayAdapter extends ArrayAdapter
{

    private Context mContext;
    private Loyalty[] LoyaltyList;
    private int textViewResourceId;

    public LoyaltyProgramArrayAdapter(Context context, int textViewResourceId,
                                  Loyalty[] list)
    {
        super(context, textViewResourceId , list);
        this.mContext = context;
        this.LoyaltyList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //android will re-use existing rows for performance reasons.
        //this checks to see if the convertView is already a thing or not
        //if it is not a thing, it inflates the layout for use this time
        //it will likely be a thing the next time we process this row.
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        TextView lpName = (TextView)listItem.findViewById(R.id.lpNameTV);
        TextView lpBankName = (TextView)listItem.findViewById(R.id.lpBankAffTV);
        TextView lpBalance = (TextView)listItem.findViewById(R.id.lpBalanceTV);
        Loyalty lp = this.LoyaltyList[position];

        lpName.setText(lp.getName());
        lpBankName.setText(lp.getBankaff());
        lpBalance.setText("" + lp.getBalance());

        //return the View after we have set all of the values
        return listItem;
    }
}
