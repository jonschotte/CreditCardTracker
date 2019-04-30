package com.example.creditcardtracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class BTMain extends AppCompatActivity {

    private ListView airportLV;
    private LinkedList<String> theAirportStrings = new LinkedList<String>();
    private LinkedList<Airport> theFilteredAirports = new LinkedList<Airport>();
    private LinkedList<Airport> theAirports = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;
    private TextView payloadTV;
    private Button leftButton;
    private Button rightButton;
    private BTreeNode myTree;
    private BinaryTree airportTree;
    private BTMain myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btmain);

        this.payloadTV = this.findViewById(R.id.payloadTV);
        this.leftButton = this.findViewById(R.id.leftButton);
        this.rightButton = this.findViewById(R.id.rightButton);

/*
    BinaryTree bt = new BinaryTree();
        bt.addValue(1);
        bt.addValue(12);
        bt.addValue(3);
        bt.addValue(4);
        bt.visitInOrder();
        bt.visitPostOrder();
        bt.visitPreOrder();
*/

        //get the tree owned by this BTMainActivity
        if(this.getIntent().hasExtra("myTree"))
        {
            this.myTree = (BTreeNode) this.getIntent().getSerializableExtra("airportCode");
            //this.myTree = (BinaryTree2)this.getIntent().getStringArrayListExtra("airportCode");
        }
        else
        {


            this.myTree = new BTreeNode("hat");
            //this.myTree.add("hat");
            //this.myTree.add("taco");
            //this.myTree.add("cat");
            //this.myTree.add("bat");


        }

        this.payloadTV.setText("" + this.myTree.payload);
        this.hideButtonsIfNeeded();
    }

    private void hideButtonsIfNeeded()
    {
        if(this.myTree.leftChild == null)
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }

        if(this.myTree.rightChild == null)
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
    }

    public void onLeftButtonClicked(View v)
    {
        Intent i = new Intent(this, BTMain.class);
        i.putExtra("myTree", this.myTree.leftChild);
        this.startActivity(i);
    }

    public void onRightButtonClicked(View v)
    {
        Intent i = new Intent(this, BTMain.class);
        i.putExtra("myTree", this.myTree.rightChild);
        this.startActivity(i);
    }
}
