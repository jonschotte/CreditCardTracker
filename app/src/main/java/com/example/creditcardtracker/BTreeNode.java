package com.example.creditcardtracker;

import java.io.Serializable;

public class BTreeNode implements Serializable
{
    public String payload;
    public BTreeNode leftChild;
    public BTreeNode rightChild;

    public BTreeNode(String payload)
    {
        this.payload = payload;
        this.leftChild = null;
        this.rightChild = null;
    }

    public String visitInOrder()
    {
        String answer = "";
        if(this.leftChild != null)
        {
            answer = answer + " " + this.leftChild.visitInOrder();
        }
        answer = answer + " " + this.payload;
        if(this.rightChild != null)
        {
            answer = answer + " " + this.rightChild.visitInOrder();
        }
        return answer;
    }

    public String visitPreOrder()
    {
        String answer = "";
        answer = answer + " " + this.payload;
        if(this.leftChild != null)
        {
            answer = answer + " " + this.leftChild.visitPreOrder();
        }
        if(this.rightChild != null)
        {
            answer = answer + " " + this.rightChild.visitPreOrder();
        }
        return answer;
    }

    public String visitPostOrder()
    {
        String answer = "";
        if(this.leftChild != null)
        {
            answer = answer + " " + this.leftChild.visitPostOrder();
        }
        if(this.rightChild != null)
        {
            answer = answer + " " + this.rightChild.visitPostOrder();
        }
        answer = answer + " " + this.payload;
        return answer;
    }

    public void addNode(BTreeNode n)
    {

        if(n.getPayload().compareTo(this.payload) == 1)
        {
            if(this.leftChild == null)
            {
                this.leftChild = n;
            }
            else
            {
                this.leftChild.addNode(n);
            }
        }
        else
        {
            if(this.rightChild == null)
            {
                this.rightChild = n;
            }
            else
            {
                this.rightChild.addNode(n);
            }
        }
    }

    public BTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public String getPayload() {
        return payload;
    }
}
