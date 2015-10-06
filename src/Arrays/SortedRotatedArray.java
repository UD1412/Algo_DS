package Arrays;
import java.util.*;
/**
 * Created by Upasana on 9/28/2015.
 */


public class SortedRotatedArray {

    public static int FindMin(int[] arr)
    {
        if( arr == null)
            throw new NullPointerException();

        if( arr.length ==0)
            return -1;

        return FindMinInRotatedArray(arr, 0, arr.length -1);

    }

    public static int FindMinInRotatedArray(int[] arr,int st,int end)
    {
        if( st > end)
            return -1;

        if(arr[st] < arr[end])
            return st;

        if( st == end)
            return st;

        int mid = (st +end)/2;

        if(arr[mid +1] < arr[mid])
            return mid+1;
        else if(arr[st] > arr[mid])
            return FindMinInRotatedArray(arr, st, mid);
        else if (arr[mid+1] > arr[end])
            return FindMinInRotatedArray(arr, mid+1, end);

        return -1;

    }

    public static int BinarySearch(int[] arr, int val,int st, int end)
    {
        System.out.println("Binary Search "+  val + "  st = "+st+ " end = "+ end );
        if( st > end)
            return -1;

        int mid;
        while( st < end) {
            mid = (st+end)/2;

            if(st == end )
            {
                if (arr[st] != val) {
                    return -1;
                }
                else{
                    return st;
                }
            }

            if (arr[mid] == val)
                return mid;

            if( (val > arr[end]) ||( val < arr[st]))
                    return -1;

            if (arr[mid] > val) {
                end = mid-1;
            } else {
                st = mid+1;
            }
        }
        return -1;
    }

    public static int FindElement(int[] arr, int val, int st, int end)
    {
        if( st > end)
            return -1;

        if(( st == end ) && (arr[st] != val)) {
            return -1;
        }
        else if(( st == end ) && (arr[st] == val)) {
            return st;
        }

        int mid = (st+end)/2;

        if( arr[mid] == val)
        {
            return mid;
        }else if( arr[st] < arr[end])
        {
            return BinarySearch( arr,val, st, end);
        }else if(arr[st]< arr[mid] && val > arr[st] && val < arr[mid]){
            return BinarySearch(arr, val, st, mid-1);
        } else if(arr[mid]< arr[end] && val > arr[mid] && val < arr[end]){
            return BinarySearch(arr, val, mid+1, end);
        }

        if( arr[mid] < arr[st])
        {
            return FindElement(arr, val, st, mid-1);
        }
        if( arr[end] < arr[mid])
        {
            return FindElement(arr, val, mid+1, end);
        }

        return -1;

    }


    public static int FindElementIter(int[] arr, int val, int st, int end)
    {
        if( st > end)
            return -1;

        if(( st == end ) && (arr[st] != val)) {
            return -1;
        }
        else if(( st == end ) && (arr[st] == val)) {
            return st;
        }

        while( st <= end) {
            int mid = (st + end) / 2;

            if (arr[mid] == val) {
                return mid;
            }
            if (arr[st] < arr[mid]) {

                if (val > arr[st] && val < arr[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else
            {
                if (val > arr[mid] && val < arr[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }

            }

        }

        return -1;

    }

    public static void main(String[] args) {

        int[] arr = {6, 8, 10, 14, 17, 18, 2, 4, 5};
        int[] arr1 = {6, 8, 10, 14, 17, 18, 22,24, 25};
        int[] arr2 = {6, 8, 10, 14, 17, 18, 22,24, 5};
        int[] arr8 = {96, 8, 17, 24, 37, 48, 52,64, 75};

        int index = FindMin(arr);
        System.out.println(arr[index]);


        index = FindMin(arr1);
        System.out.println(arr[index]);


        index = FindMin(arr2);
        System.out.println(arr[index]);


        index = FindMin(arr8);
        System.out.println("index = "+index);
        System.out.println(arr[index]);

        System.out.println("NEW PROGRAM");
        index = FindElement(arr, 18, 0, 8);
        System.out.println(index);
        //System.out.println(arr[index]);


        index = FindElement(arr, 3, 0, 8);
        System.out.println(index);
        //System.out.println(arr[index]);


        index = FindElement(arr, 9, 0, 8);
        System.out.println(index);
       // System.out.println(arr[index]);

        System.out.println("NEW PROGRAM ITER");
        index = FindElementIter(arr, 18, 0, 8);
        System.out.println(index);
        //System.out.println(arr[index]);


        index = FindElementIter(arr, 3, 0, 8);
        System.out.println(index);
        //System.out.println(arr[index]);


        index = FindElementIter(arr, 9, 0, 8);
        System.out.println(index);


    }
}

