package com.Trees;
import DSHelperClasses.TreeNode;
import java.lang.*;

import java.util.*;
/**
 * Created by Upasana on 9/28/2015.
 */

class InorderFlag
{
    public boolean nodeFound = false;
    InorderFlag(boolean val){
        this.nodeFound = val;
    }
}
class BSTree<T extends Comparable<T>>
{
    TreeNode<T> root;
    BSTree()
    {
        this.root = null;
    }

    public void AddNode(int val)
    {
        TreeNode<T> nNode = new TreeNode(val);
        this.root =  AddNode(root, nNode);
    }
    private TreeNode AddNode(TreeNode<T> root, TreeNode<T> nNode)
    {
        if (root == null)
            return nNode;

        if(root.compareTo(nNode) < 0)
            root.right = AddNode(root.right, nNode);
        else
            root.left = AddNode(root.left, nNode);

        return root;

    }
    //public boolean RemoveNode(int val)
    //    public boolean IsBST()
    public void InOrderTraversal()
    {

        InOrderTraversal( root);
    }
    private void InOrderTraversal(TreeNode<T> root)
    {
        if( root == null)
            return;
        InOrderTraversal( root.left);
        System.out.println(root.val);
        InOrderTraversal(root.right);
    }

    public TreeNode<T> InOrderSuccessor(int a){

        InorderFlag flag = new InorderFlag(false);
        return  InOrderSuccessor( a, root, flag);
    }

    private TreeNode<T> InOrderSuccessor(Integer a, TreeNode<T> root, InorderFlag flag)
    {
        if( root == null)
            return root;

        TreeNode<T> successor = InOrderSuccessor( a, root.left, flag);

        if( successor != null)
            return successor;

        if( flag.nodeFound) {
            System.out.println("Node found");
            flag.nodeFound = false;
            return root;
        }

        if( root.GetValue()==a) {
            flag.nodeFound = true;
        }

        successor = InOrderSuccessor( a, root.right, flag);
        if( successor != null)
            return successor;


        return null;
    }
}

public class InOrderSuccessorBST {
    public static void main(String[] args) {
        BSTree MyTree = new BSTree();
        MyTree.AddNode(20);
        MyTree.AddNode(22);
        MyTree.AddNode(2);
        MyTree.AddNode(12);
        MyTree.AddNode(34);
        MyTree.AddNode(99);
        MyTree.AddNode(9);
        MyTree.AddNode(14);
        MyTree.InOrderTraversal();

        System.out.println("Inorder successor");
        System.out.println("9  " + (MyTree.InOrderSuccessor(9).val));
        System.out.println("12  " + (MyTree.InOrderSuccessor(12).val));

        // System.out.println("99  " + (MyTree.InOrderSuccessor(99).val));       // will give NPE as Inorder successor of 99 is null


    }
}

































