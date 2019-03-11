package com.example.creditcardtracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LoyaltyArrayAdapterForLinkedLists extends ArrayAdapter
{
    private Context mContext;
    private LinkedListOfLoyalty LoyaltyList;
    private int textViewResourceId;

    public LoyaltyArrayAdapterForLinkedLists(Context context, int textViewResourceId,
                                                LinkedListOfLoyalty list)
    {
        super(context, textViewResourceId);
        this.mContext = context;
        this.LoyaltyList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public int getCount()
    {
        return this.LoyaltyList.length();
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

        TextView lpName = (TextView)listItem.findViewById(R.id.lpNameTV);
        TextView lpBankName = (TextView)listItem.findViewById(R.id.lpBankAffTV);
        TextView lpBalance = (TextView)listItem.findViewById(R.id.lpBalanceTV);
        Loyalty lp = this.LoyaltyList.getAtIndex(position);

        lpName.setText(lp.name);
        lpBankName.setText(lp.bankaff);
        lpBalance.setText("" + lp.pointbalance);

        //return the View after we have set all of the values
        return listItem;
    }
}
