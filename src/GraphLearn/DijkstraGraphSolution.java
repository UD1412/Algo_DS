package GraphLearn;

import java.util.*;

/**
 * Created by Upasana on 9/25/2015.
 */

class Vertex
{
    public String id;
    public String name;
    Vertex ( String id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class Edge
{
    public String name;
    public  int weight;
    public  Vertex src;
    public Vertex dest;
    Edge(String name,  Vertex src, Vertex  dest, int weight)
    {
        this.name = name;
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }
}

class DGraph {
    public List<Vertex> Vertices;
    public List<Edge> Edges;
    DGraph(List<Vertex> Vertices, List<Edge> Edges)
    {
        this.Vertices = Vertices;
        this.Edges = Edges;
    }
    public List<Vertex> GetVertices()
    {
        return Vertices;
    }
    public List<Edge> GetEdges()
    {
        return Edges;
    }

    public boolean IfPathExists(Vertex a, Vertex b)
    {
        if ( Vertices == null || Edges == null || a == null || b == null)
            return false;
        if(!Vertices.contains(a) ||!Vertices.contains(b))
            return false;

        Set<Vertex> Visited = new HashSet<Vertex>();
        return IfPathFound(a, b, Visited);

    }

    private boolean IfPathFound(Vertex src, Vertex dest, Set<Vertex> Visited)
    {
        if ( src == null)
            return false;

        if( src == dest)
            return true;

        Visited.add(src);
        for( Edge e: Edges)
        {
            if(e.src == src) {
                if (e.dest == dest)
                    return true;
                if (!Visited.contains(e.dest)) {
                    boolean pathPresent = IfPathFound(e.dest, dest, Visited);
                    if (pathPresent)
                        return true;
                }
            }
        }
        return false;
    }
}


class DijkstraAlgorithm
{
    public List<Vertex> Vertices;
    public List<Edge> Edges;
    HashSet<Vertex> ToVisitNodes = new HashSet<Vertex>();
    HashSet<Vertex> VisitedNodes = new HashSet<Vertex>();
    HashMap<Vertex, Vertex>PathMap = new HashMap<Vertex, Vertex>();
    HashMap<Vertex, Integer>DistMap = new HashMap<Vertex, Integer>();

    DijkstraAlgorithm( DGraph graph)
    {
        Vertices = graph.GetVertices();
        Edges = graph.GetEdges();
    }

    public void DijkstraGraphAlgo(Vertex src)
    {
        ToVisitNodes.add(src);
        DistMap.put(src, 0);
        PathMap.put( src, src);
        //find minimum distance from Src
        while(ToVisitNodes.size() >0) {

            Vertex currNode = FindMinimum(ToVisitNodes, DistMap);

            ToVisitNodes.remove(currNode);
            VisitedNodes.add(currNode);

            List<Vertex> neighbours = FindNeighbours(currNode);
            for( Vertex node: neighbours)
            {
                ToVisitNodes.add(node);
                UpdateDistanceForDjkstra(currNode, node);
            }
        }


    }

    private void UpdateDistanceForDjkstra(Vertex a, Vertex b)
    {
        int distToSrc = DistMap.get(a);
        int nodeDist = FindDistance(a, b);
        if (!DistMap.containsKey(b))
            DistMap.put(b, distToSrc + nodeDist);
        else if (DistMap.get(b)> (distToSrc+nodeDist))
            DistMap.put(b, distToSrc + nodeDist);
            PathMap.put(b, a);


        return;

    }

    //parse through all etnries in DistMap and return teh vertex with minimum distance value excspt the src
    private Vertex FindMinimum(HashSet<Vertex> ToVisitNodes, HashMap<Vertex, Integer> DistMap)
    {

        int dist = Integer.MAX_VALUE;
        Vertex n = null;
        for(Vertex node: ToVisitNodes)
        {
            if(DistMap.get(node) < dist)
            {
                dist = DistMap.get(node);
                n = node;
            }

        }
        return n;
    }

    private List<Vertex> FindNeighbours(Vertex node)
    {
        List<Vertex> edgeList = new ArrayList<Vertex>();

            for( Edge e : Edges)
            {
               if( e.src == node)
                   edgeList.add(e.dest);
            }
        return edgeList;
    }

    public int FindDistance( Vertex a , Vertex b)
    {
       for(Edge e: Edges)
       {
           if( e.src == a && e.dest == b)
               return e.weight;
       }
        return 0;
    }



    public List<Vertex> GetPath(Vertex dest)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        path.add(dest);
         boolean loop = true;
        while(loop)
        {
            if( PathMap.get(dest) != dest)
            {
                Vertex newDest = PathMap.get(dest);
                path.add(0,newDest);
                dest = newDest;
            }
            else
            {
                loop = false;
            }
        }
        return path;
    }


}

public class DijkstraGraphSolution {

    public static List<Vertex> nodes;
    public static List<Edge> edges;
    private static void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
    public static void main(String[] args)
    {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        DGraph graph = new DGraph(nodes, edges);

        System.out.println("****If PAth Exists****");
        boolean  pathExists = graph.IfPathExists(nodes.get(0), nodes.get(8));
        System.out.println("pathExists = " + pathExists);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.DijkstraGraphAlgo(nodes.get(0));

        List<Vertex> path = dijkstra.GetPath(nodes.get(10));


        for (Vertex vertex : path) {
            System.out.println(vertex.name);
        }

    }


}

