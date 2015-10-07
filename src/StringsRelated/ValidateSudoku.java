package StringsRelated;

import java.util.*;
/**
 * Created by Upasana on 9/18/2015.
 */
public class ValidateSudoku {
    public static boolean ValidSudoku( int[][] Arr)
    {
        if (Arr == null)
            return false;

        //Should eb sqaure matrix, size divisible by 3
        if((Arr.length != Arr[0].length)  || (Arr.length%3 != 0))
            return false;

        int maxVal = Arr.length;
        int minVal = 1;

        //Verify all rows
        for( int i = 0; i < Arr.length; i++)
        {
            Set<Integer> NumSet = new HashSet<Integer>();

            for ( int j =0; j < Arr.length; j++)
            {
                //numbers should be within a given range of min and max
                // for a 9x9 matrix min val =1;maxVal =9
                if(Arr[i][j] > maxVal || Arr[i][j] < minVal)
                    return false;

                //Number should appear only once in the row
                if( NumSet.contains(Arr[i][j])){
                    return false;
                }
                else {
                    NumSet.add(Arr[i][j]);
                }
            }
        }

  //:w!
  //      String a = "anagram";
//        String sorteda =



        //Verify all columns
        for( int i = 0; i < Arr.length; i++)
        {
            Set<Integer> NumSet = new HashSet<Integer>();

            for ( int j =0; j < Arr.length; j++)
            {
                //numbers should be within a given range of min and max
                // for a 9x9 matrix min val =1;maxVal =9
                if(Arr[j][i] > maxVal || Arr[j][i] < minVal)
                    return false;

                //Number should appear only once in the row
                if( NumSet.contains(Arr[j][i])){
                    return false;
                }
                else {
                    NumSet.add(Arr[j][i]);
                }
            }
        }


        //Verify each box

        for(int k =0; k < (Arr.length)/3; k++)
        {
            //verify teh box
            //iterating through all sub locks possible with teh first length/3 rows
            for(int l =0; l < (Arr.length)/3; l++)
            {
                Set<Integer> NumSet = new HashSet<Integer>();
                for(int i=k*3+ 0;i < (k*3+(Arr.length)/3); i++ )
                {

                    for(int j=l*3+ 0;j < (l*3+(Arr.length)/3);j++ )
                    {
                        //numbers should be within a given range of min and max
                        // for a 9x9 matrix min val =1;maxVal =9
                        if(Arr[i][j] > maxVal || Arr[i][j] < minVal)
                            return false;

                        //Number should appear only once in the row
                        if( NumSet.contains(Arr[i][j])){
                            return false;
                        }
                        else {
                            NumSet.add(Arr[i][j]);
                        }
                    }

                }
            }
        }


        return true;
    }
    public static void main( String[] args)
    {
        int[][] Sudoku = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };

        System.out.println(ValidSudoku(Sudoku));

    }

}
