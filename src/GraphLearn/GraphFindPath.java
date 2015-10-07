package GraphLearn;

/**
 * Created by Upasana on 9/16/2015.
 */


import java.util.*;
import java.lang.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Node <T>
{
    private T val;
    private List<Node<T>> Edges;

    Node( T item) {
        this.val = item;
        Edges = new ArrayList<Node<T>>();
    }

    public boolean AddEdge(Node<T> edge)
    {
        Edges.add(edge);
        return true;
    }

    public T GetVal()
    {
        return val;
    }

    public List<Node<T>> GetEdges()
    {

        return Edges ;
    }

};

class TGraph<T>
{
    private Node<T> root;

    TGraph (Node<T> root)
    {
        this.root = root;
    }

    public boolean AddEdge(Node<T> a, Node<T> b)
    {
        if( a != null & b != null) {
            a.AddEdge(b);
            b.AddEdge(a);
        }
        return true;
    }

    public boolean IfPathExistsDFS(Node<T> a, Node<T> b)
    {
        if(a == null || b == null)
            return true;

        Set<Node<T>> VisitedNode = new HashSet<Node<T>>();

        Stack<Node<T>> DFSStack = new Stack<Node<T>>();

        DFSStack.push(a);

        while(!DFSStack.empty())
        {
            Node<T> currNode = DFSStack.pop();
            System.out.println("Current StackTop = " + currNode.GetVal());
            VisitedNode.add(currNode);

            for(Node<T> nNode: currNode.GetEdges())
            {

                if(nNode == b)
                    return true;

                if(!VisitedNode.contains(nNode))
                    DFSStack.push(nNode);
            }
            System.out.println("*****************");
            System.out.println(DFSStack.size());
        }

        return false;
    }

    public boolean IfPathExistsBFS(Node<T> a, Node<T> b)
    {

        if ( a == null || b == null) {
            return true;
        }

        Queue <Node<T>> BFSQ = new ArrayDeque<Node<T>>();
        Set<Node<T>> VisitedNode = new HashSet<Node<T>>();

        BFSQ.add(a);

        while(!BFSQ.isEmpty())
        {

            Node<T> currNode = BFSQ.poll();
            VisitedNode.add(currNode);
            for (Node<T> nNode: currNode.GetEdges())
            {

                if( nNode == b)
                    return true;

                if(!VisitedNode.contains(nNode))
                    BFSQ.add(nNode);
            }
        }
        return false;
    }
};

public class Solution {
    public static void main(String[] args) {

        Node<Integer> a = new Node<Integer>(5);
        Node<Integer> b = new Node<Integer>(6);
        Node<Integer> c = new Node<Integer>(7);
        Node<Integer> d = new Node<Integer>(8);
        Node<Integer> e = new Node<Integer>(9);
        Node<Integer> f = new Node<Integer>(10);


        TGraph<Integer> MyGraph = new TGraph<Integer>(a);
        MyGraph.AddEdge(a, b);
        MyGraph.AddEdge(a, c);
        MyGraph.AddEdge(b, c);
        MyGraph.AddEdge(b, d);
        MyGraph.AddEdge(c, d);
        MyGraph.AddEdge(c, e);
        MyGraph.AddEdge(d, e);
        MyGraph.AddEdge(e, f);


        System.out.println(MyGraph.IfPathExistsBFS( b, f));

        System.out.println(MyGraph.IfPathExistsDFS( b, f));

        System.out.println("Bye-Bye");

    }
}

