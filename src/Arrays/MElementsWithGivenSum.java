package Arrays;

/**
 * Created by Upasana on 9/28/2015.
 */
public class MElementsWithGivenSum {

    public static void FindCombinations(int[] arr, int Sum)
    {
        if( arr == null)
            throw new NullPointerException();

        if( arr.length ==0)
            return;

        int[] isIncluded = new int[arr.length];
        FindAllCombs(  arr,  0, Sum,  isIncluded);

    }

    public static void FindAllCombs( int[] arr, int currIndex,int reqdSum, int[] isIncluded)
    {
        if( currIndex == arr.length)
        {
            if( reqdSum ==0)
                PrintCombination(arr, isIncluded);

            return;
        }


        //Include teh value and find all combinations
        isIncluded[currIndex] = 1;
        FindAllCombs( arr, currIndex+1, reqdSum - arr[currIndex],isIncluded);

        // Donot include this entry and compuet all combinations
        isIncluded[currIndex] = 0;
        FindAllCombs( arr, currIndex+1, reqdSum,isIncluded);

    }

    public static void PrintCombination( int[] arr, int[] isIncluded)
    {
        for( int i =0; i< arr.length; i++)
        {
            if(isIncluded[i] ==1)
                System.out.print( arr[i] + "    ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        int[] arr = {2, 8, 6, 1, 3, 12, -5, 19, -9, 15, 5};
        FindCombinations(arr, 12);


    }
}

