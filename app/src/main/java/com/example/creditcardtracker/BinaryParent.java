package com.example.creditcardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryParent extends AppCompatActivity {

    private LinkedList<String> ll = new LinkedList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_parent);

        ll.add("A");
        ll.add("B");
        ll.add("C");



    }

    public void LinkedListToBinaryTree(LinkedList ll)
    {

        Node head;
        String parent  = head;

    }

    public void leftChild()
    {

    }

        if (head == null)
        {
            node = null;
            return null;
        }

        node = new BinaryTreeNode(head.data);
        q.add(node);

        head = head.next;

        while(head != null)
        {
            BinaryTreeNode parent =ll.peek();
            BinaryTreeNode pp =ll.poll();

            BinaryTreeNode leftChildNode = null;
            BinaryTreeNode rightChildNode = null;
            leftChildNode = new BinaryTreeNode(head.data);
            q.add(leftChildNode);
            head = head.next;
            if (head != null)
            {
                rightChildNode = new BinaryTreeNode(head.data);
                q.add(rightChildNode);
                head = head.next;
            }

            parent.leftNode = leftChildNode;
            parent.rightNode = rightChildNode;
        }



        BinaryTree tree = new BinaryTree();
        tree.push(36); /* Last node of Linked List */
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10); /* First node of Linked List */
        BinaryTreeNode node = tree.LinkedListToBinaryTree(tree.root);

        System.out.println("Inorder Traversal of the constructed Binary Tree is:");
        System.out.println("Inorder Traversal ** " + );
        tree.InOrderTraversal(node);

    }

    class LinkedListNode
    {
        int data;
        LinkedListNode next;
        LinkedListNode(int d)
        {
            data = d;
            next = null;
        }
    }

    class BinaryTreeNode
    {
        int data;
        BinaryTreeNode leftNode = null;
        BinaryTreeNode rightNode = null;
        BinaryTreeNode(int data)
        {
            this.data = data;
            leftNode = rightNode = null;
        }
    }

    class BinaryTree
    {
        LinkedListNode head;
        BinaryTreeNode root;

        void push(int new_data)
        {
            LinkedListNode new_node = new LinkedListNode(new_data);
            new_node.next = head;
            head = new_node;
        }

        BinaryTreeNode LinkedListToBinaryTree(BinaryTreeNode node)
        {


            if (head == null)
            {
                node = null;
                return null;
            }

            node = new BinaryTreeNode(head.data);
            q.add(node);

            head = head.next;

            while(head != null)
            {
                BinaryTreeNode parent =ll.peek();
                BinaryTreeNode pp =ll.poll();

                BinaryTreeNode leftChildNode = null;
                BinaryTreeNode rightChildNode = null;
                leftChildNode = new BinaryTreeNode(head.data);
                q.add(leftChildNode);
                head = head.next;
                if (head != null)
                {
                    rightChildNode = new BinaryTreeNode(head.data);
                    q.add(rightChildNode);
                    head = head.next;
                }

                parent.leftNode = leftChildNode;
                parent.rightNode = rightChildNode;
            }

            return node;
        }

        void InOrderTraversal(BinaryTreeNode node)
        {
            if (node != null)
            {
                InOrderTraversal(node.leftNode);
                System.out.println("******Node -> " + node.data);
                InOrderTraversal(node.rightNode);
            }
        }

    }


}
