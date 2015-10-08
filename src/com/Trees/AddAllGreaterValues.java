package com.Trees;

/**
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/.
 */

// Just because there is no way to pass the primitive type variable by reference in Java x-(
class IntegerWrapper
{
    int val;
}

public class AddAllGreaterValues {

    public static void InOrderTraversal(Node root)
    {
        if( root == null)
            return;

        InOrderTraversal(root.left);
        System.out.print(root.val + "    ");
        InOrderTraversal(root.right);

    }
    public static void AddAllValuesGreater(Node root) {
        IntegerWrapper iwrapper = new IntegerWrapper();
        AddAllValuesGreaterThanNode(root, iwrapper);
        return;
    }

    private static void AddAllValuesGreaterThanNode(Node root, IntegerWrapper valueToAdd)
    {
        if( root == null)
            return ;

        AddAllValuesGreaterThanNode(root.right, valueToAdd);
        root.val+= valueToAdd.val;
        valueToAdd.val = root.val;
        AddAllValuesGreaterThanNode(root.left, valueToAdd);

        return ;
    }

    public static void main( String[] args)
    {

        BinaryTree bt = new BinaryTree();

        bt.addNode(50);
        bt.addNode(30);
        bt.addNode(70);
        bt.addNode(20);
        bt.addNode(40);

        bt.addNode(60);
        bt.addNode(80);

        InOrderTraversal(bt.root);
        System.out.println();

        AddAllValuesGreater( bt.root);
        InOrderTraversal(bt.root);


    }
}
