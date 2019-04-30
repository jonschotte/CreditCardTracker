package com.example.creditcardtracker;

import java.io.Serializable;

public class BinaryTree implements Serializable
{
    private BTreeNode root;

    public BinaryTree()
    {
        this.root = null;
    }

    public void visitInOrder()
    {
        if(this.root != null)
        {
            System.out.println("*** In Order:" + this.root.visitInOrder());
        }
    }

    public void visitPostOrder()
    {
        if(this.root != null)
        {
            System.out.println("*** Post Order:" + this.root.visitPostOrder());
        }
    }

    public void visitPreOrder()
    {
        if(this.root != null)
        {
            System.out.println("*** Pre Order:" + this.root.visitPreOrder());
        }
    }

    public void addValue(String payload)
    {
        BTreeNode n = new BTreeNode(payload);
        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            //My tree has stuff in it
            this.root.addNode(n);
        }
    }
}
