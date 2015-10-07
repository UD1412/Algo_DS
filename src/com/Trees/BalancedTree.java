package com.Trees;

class ANode <T>
{
    T val;
    ANode left;
    ANode right;

    ANode(T val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
};
public class BalancedTree {

    public  static boolean IsBalancedTree(ANode root)
    {
        return (IsBalanced(root) != -1);
    }
    private static int IsBalanced ( ANode root)
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
        ANode root = new ANode(5);
        ANode l1 = new ANode(4);
        ANode l2 = new ANode(8);
        ANode l3 = new ANode(3);
        ANode r1 = new ANode(7);

        root.left = l1;
        l1.left = l2;
        l1.right = l3;
        root.right = r1;
        System.out.println(IsBalancedTree(root));
        ANode l4 = new ANode(9);
        l3.left = l4;
        System.out.println(IsBalancedTree(root));
    }
};
