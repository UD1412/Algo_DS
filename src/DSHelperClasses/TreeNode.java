package DSHelperClasses;
import java.lang.*;

import java.util.Comparator;

/**
 * Created by Upasana on 10/6/2015.
 * * Basic definition of a Node of a List
 */
public class TreeNode<T extends Comparable<T>> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }


    public T GetValue()
    {
        return this.val;
    }
    public int compareTo(Object o) {
        TreeNode<T> currNode = (TreeNode) o;
        return val.compareTo(currNode.val);

    }

}
