package com.Trees;

class Node <T>
{
    T val;
    Node left;
    Node right;

    Node(T val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
};
public class BalancedTree {

    public  static boolean IsBalancedTree(Node root)
    {
        return (IsBalanced(root) != -1);
    }
    private static int IsBalanced ( Node root)
    {
        if( root == null)
        {
          return 0;
        }

        int leftDepth = IsBalanced(root.left);
        int rightDepth = IsBalanced(root.right);

        if ( (leftDepth == -1) || ( rightDepth == -1) || (Math.abs(leftDepth-rightDepth) > 1) )
            return -1;

        return Math.max(leftDepth, rightDepth) +1;
    }


    public  static void main(String[] args) {

        System.out.println("Hello World.");
        Node root = new Node(5);
        Node l1 = new Node(4);
        Node l2 = new Node(8);
        Node l3 = new Node(3);
        Node r1 = new Node(7);

        root.left = l1;
        l1.left = l2;
        l1.right = l3;
        root.right = r1;
        System.out.println(IsBalancedTree(root));
        Node l4 = new Node(9);
        l3.left = l4;
        System.out.println(IsBalancedTree(root));
    }
};
