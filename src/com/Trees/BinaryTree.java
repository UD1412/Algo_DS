package com.Trees;

/**
 * Created by Upasana on 10/7/2015.
 */

//The Binary tree class
public class BinaryTree
{
    Node root;
    public BinaryTree()
    {
        root = null;
    }

    //Creates a BST
    public void addNode(int data){

        Node nNode = new Node(data);

        if(root == null){
            root = nNode;
            return ;
        }
        Node parent = null;
        Node head = root;

        while(head != null){
            parent = head;
            if(head.val < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }
        if(parent.val < data){
            parent.right = nNode;
        }else{
            parent.left = nNode;
        }

    }

}