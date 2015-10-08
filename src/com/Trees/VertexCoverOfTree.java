package com.Trees;

/**
 * Find thh Vertex cover of a Binary Tree
 */



//Finding teh Vertex cover of the Tree
// It is based on the fact that if the parent is included in the vertex cover,
// none of its child should be a part of it.

// So the API recursively computes the Vertex cover for both teh possibilities
// 1- When root is a part fo Vertex cover
// 2- When root is not a part fo Vertex cover and its child/children are.
// returns the minimum of the two.
public class VertexCoverOfTree {

    private BinaryTree bTree;
    VertexCoverOfTree(BinaryTree bt)
    {
        this.bTree = bt;
    }
    public int VertexCover()
    {
        return Math.min(FindCover(bTree.root, true), FindCover(bTree.root, false));
    }

    public int FindCover(Node root, boolean isIncluded)
    {
        if ( root == null)
            return 0;

        if( isIncluded) {
            return FindCover(root.left, false) + FindCover(root.right, false) + 1;
        }else {
            return FindCover(root.left, true) + FindCover(root.right, true);
        }
    }

    public static void main( String[] args)
    {
        BinaryTree bt = new BinaryTree();

        bt.addNode(10);
        bt.addNode(15);
        bt.addNode(5);
        bt.addNode(7);
        bt.addNode(19);

        bt.addNode(-1);
        bt.addNode(13);
        //Uncomment the following lines to generate a larger Btree

       /* bt.addNode(2);
        bt.addNode(6);
        bt.addNode(12);
        bt.addNode(20);*/

        VertexCoverOfTree VCT = new VertexCoverOfTree(bt);
        System.out.println(VCT.VertexCover());
    }
}
