package GraphLearn;
import java.util.*;
/**
 * Created by Upasana on 9/28/2015.
 */
public class HousePainting {

    public static void HousePaintnig(int[][]costMatrix)
    {
        int[] colors = new int[costMatrix.length];
        int[] finalColors = new int[costMatrix.length];
        HousePaintMinCost(costMatrix, colors,finalColors, 0, 0, Integer.MAX_VALUE);
        for( int i =0; i < costMatrix.length; i++)
        {
           System.out.println(finalColors[i]);
        }
    }

    public static void HousePaintMinCost(int [][]costMatrix,int[] chosenColors,int[] finalColors, int currIndex, int currCost, int minCost)
    {
        if ( currIndex == costMatrix.length)
        {
            if( currCost < minCost){
                minCost = currCost;
                for( int i =0; i < costMatrix.length; i++)
                {
                    finalColors[i] = chosenColors[i];
                }
            }
            return;
        }


        for( int i = 0; i < costMatrix[currIndex].length; i++)
        {
            if( currIndex > 0 && chosenColors[currIndex -1] == i)
                continue;

            chosenColors[currIndex] = i;
            int cost = currCost+ costMatrix[currIndex][i];
            HousePaintMinCost(costMatrix, chosenColors, finalColors, currIndex+1, cost, minCost);

        }
    }



    private static Colouring getColouring(int[][]costMatrix, int position, int previousColor) {
        if (position == costMatrix.length) {
            return new Colouring();
        }

        Colouring cheapestColouring = null;
        int minCost = Integer.MAX_VALUE;

        for (int colorIndex = 0; colorIndex < costMatrix[0].length; colorIndex++) {
            if (colorIndex == previousColor) {
                continue;
            }
            Colouring nextColouring = getColouring(costMatrix, position + 1, colorIndex);
            int cost = costMatrix[position][colorIndex] + nextColouring.totalCost;
            if (cost < minCost) {
                nextColouring.colours.add(0, colorIndex);
                nextColouring.totalCost = cost;
                cheapestColouring = nextColouring;
            }
        }
        return cheapestColouring;

    }

    private static class Colouring {
        public List<Integer> colours = new ArrayList<Integer>();
        int totalCost = 0;
    }



    public static void main(String [] args)
    {
        //rows are teh house numbers
        // columns refer the different colors
        int[][] costMatrix = {
                {7, 5, 10},
                {3, 6, 1},
                {8, 7, 4},
                {6, 2, 9},
                {1, 4, 7},
                {2, 3, 6}};



        HousePaintnig(costMatrix);


        System.out.println("Another method");
        Colouring  c = getColouring(costMatrix, 0, -1);
        List<Integer> housep = c.colours;
        for(Integer i : housep)
        {
            System.out.println(i);
        }


    }
}

















