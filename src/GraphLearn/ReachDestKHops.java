package GraphLearn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Upasana on 10/9/2015.
 */

class GNode
{
    int val;
    List<GNode> nghbr;
    GNode( int val)
    {
        this.val = val;
        nghbr = new ArrayList<GNode>();
    }

    public void AddDirectedNghbr(GNode b)
    {
        nghbr.add(b);
    }

}

class ReachDestKHopsPath
{
    public List<List<GNode>> FindPathsReachDest(GNode src, GNode dest, int hops)
    {
        if( hops < 0)
            return null;

        if( src == null || dest == null)
            return null;

        Set<GNode>Visited = new HashSet<GNode>();
        return FindPaths(src, dest, hops, Visited);
    }

    private List<List<GNode>> FindPaths(GNode src, GNode  dest, int hops,Set<GNode> Visited)
    {
        if( src == null)
            return null;

        List<List<GNode>> cList = new ArrayList<List<GNode>>();

        if(!Visited.contains(src)) {
            Visited.add(src);

            for (GNode nbr :src.nghbr)  {

                if( hops > 1){
                    List<List<GNode>> childList = FindPaths(nbr, dest, hops - 1, Visited);
                    cList.addAll(childList);
                }
                else {
                    if (nbr == dest && hops == 1) {
                        List<GNode> nList = new ArrayList<GNode>();
                        nList.add(nbr);
                        cList.add(nList);

                    }
                }
            }

        }

        for(List<GNode> eachList: cList)
        {
            if(eachList.size() > 0)
                eachList.add(src);
        }
        Visited.remove(src);

        return cList;
    }
}


public class ReachDestKHops {



    public static void main(String[] args)
    {
        List<GNode> Airports = new ArrayList<GNode>();

        for (int i = 0; i < 9; i++) {
            GNode Airport = new GNode(i);
            Airports.add(i, Airport);
        }

        Airports.get(0).AddDirectedNghbr(Airports.get(2));
        Airports.get(0).AddDirectedNghbr(Airports.get(3));
        Airports.get(0).AddDirectedNghbr(Airports.get(4));

        Airports.get(2).AddDirectedNghbr(Airports.get(5));
        Airports.get(2).AddDirectedNghbr(Airports.get(6));

        Airports.get(3).AddDirectedNghbr(Airports.get(6));
        Airports.get(3).AddDirectedNghbr(Airports.get(7));

        Airports.get(4).AddDirectedNghbr(Airports.get(7));

        Airports.get(5).AddDirectedNghbr(Airports.get(6));
        Airports.get(5).AddDirectedNghbr(Airports.get(8));

        Airports.get(6).AddDirectedNghbr(Airports.get(8));
        Airports.get(6).AddDirectedNghbr(Airports.get(1));

        Airports.get(7).AddDirectedNghbr(Airports.get(1));
        Airports.get(8).AddDirectedNghbr(Airports.get(1));



        // Lets check from location Loc_1 to Loc_10
        ReachDestKHopsPath countKHops = new ReachDestKHopsPath();

        System.out.println("Distance between 0 & 3");
        List<List<GNode>> count = countKHops.FindPathsReachDest(Airports.get(0), Airports.get(3), 1);

        for(List<GNode> eachList: count)
        {
            for(GNode node: eachList) {
                System.out.print(node.val + "    ");
            }

            System.out.println();
        }

        System.out.println("Distance between 0 & 1");
        count = countKHops.FindPathsReachDest(Airports.get(0), Airports.get(1), 4);

        for(List<GNode> eachList: count)
        {
            for(GNode node: eachList) {
                System.out.print(node.val + "    ");
            }

            System.out.println();
        }

    }
}
