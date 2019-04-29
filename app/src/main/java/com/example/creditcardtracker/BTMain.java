package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BTMain extends AppCompatActivity {

    private TextView payloadTV;
    private Button leftButton;
    private Button rightButton;
    private BinaryTree2 myTree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btmain);

        this.payloadTV = this.findViewById(R.id.payloadTV);
        this.leftButton = this.findViewById(R.id.leftButton);
        this.rightButton = this.findViewById(R.id.rightButton);

        //get the tree owned by this MainActivity
        if(this.getIntent().hasExtra("myTree"))
        {
            this.myTree = (BinaryTree2)this.getIntent().getSerializableExtra("myTree");
        }
        else
        {
            //this must be screen 1
            this.myTree = new BinaryTree2(5);
            this.myTree.add(3);
            this.myTree.add(3);
            this.myTree.add(8);
            this.myTree.add(6);
        }

        this.payloadTV.setText("" + this.myTree.payload);
        this.hideButtonsIfNeeded();
    }

    private void hideButtonsIfNeeded()
    {
        if(this.myTree.left == null)
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }

        if(this.myTree.right == null)
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
    }

    public void onLeftButtonClicked(View v)
    {
        Intent i = new Intent(this, BTMain.class);
        i.putExtra("myTree", this.myTree.left);
        this.startActivity(i);
    }

    public void onRightButtonClicked(View v)
    {
        Intent i = new Intent(this, BTMain.class);
        i.putExtra("myTree", this.myTree.right);
        this.startActivity(i);
    }
}
