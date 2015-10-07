package DSHelperClasses;

/**
 * Generic implementation of a Binary Tree.
 *
 */
public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    //Constructor
    BinaryTree( )
    {
        root = null;
    }

    //Add Node API, inputs a value of Type T,
    // creates a new TreeNode and inserts into the tree
    public void AddNode(T val)
    {
        TreeNode<T> nNode = new TreeNode(val);
        if( this.root == null)
        {
            this.root = nNode;
            return;
        }

        TreeNode<T> parent = null;
        TreeNode<T> head = this.root;
        while(head != null)
        {
            parent = head;
            if(head.CompareByVal(val)< 0) {
                head = head.left;
            }else
            {
                head = head.right;
            }
        }

        if( parent.CompareByVal(val) < 0)
        {
            parent.left= nNode;
        } else
        {
            parent.right = nNode;
        }
        return;

    }

    //Public API to find if the tree is balanced or not
    public boolean IsBalancedTree()
    {
        return (IsBalanced(root) != -1);
    }


    private int IsBalanced ( TreeNode<T> root)
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

    public static void main( String[] args)
    {
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();
        bTree.AddNode(10);
        bTree.AddNode(13);
        bTree.AddNode(27);
        bTree.AddNode(-10);
        bTree.AddNode(3);
        bTree.AddNode(12);
        bTree.InOrderTraversal();
        System.out.println(bTree.IsBalancedTree());

    }
}
