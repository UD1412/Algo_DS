package DSHelperClasses;

/**
 * Created by Upasana on 10/6/2015.
 * Basic definition of a Node of a List
 */
public class ListNode <T extends Comparable<T>>{
    T val;
    ListNode<T> next;
    ListNode(T val)
    {
        this.val = val;
        this.next = null;
    }

    public T GetValue()
    {
        return this.val;
    }
    public int compareTo(Object o) {
        ListNode<T> currNode = (ListNode) o;
        return val.compareTo(currNode.val);

    }
}
