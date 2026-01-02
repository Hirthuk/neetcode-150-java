package Java_Methods.Array_Methods;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayProblems {

    // A1 - 2nd largest
    public static int secondLargest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-2];
    }

    // A1 - 2nd largest Optimal
    public static int secondLargest1(int[] arr) {
//      Create a copy array instead modifying the original
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArray);
        return copyArray[copyArray.length -2];
    }

    // A2 - copy first half
    public static int[] firstHalf(int[] arr) {
        return Arrays.copyOfRange(arr, 0, (int) arr.length/2);
    }

    // A2 - copy first half - Optimal
    public static int[] firstHalf1(int[] arr) {
        int[] copyArray = Arrays.copyOf(arr, arr.length);
        return Arrays.copyOfRange(arr, 0, arr.length/2);
    }

    // A3 - binary search
    public static int search(int[] arr, int target) {
//      Binary search works with sorted Array only
        int[] sorted = Arrays.copyOf(arr, arr.length);
        return Arrays.binarySearch(sorted, target);
    }

    // A4 - fill
    public static int[] fillArray() {
        int[] arr = new int[30];
        Arrays.fill(arr, -1);
        for(int i=0; i < arr.length; i=i+3) {
            arr[i] = 0;
        }
        return arr;
    }

    // A5 - array equals
    public static boolean areSame(int[] a, int[] b) {
        return Arrays.equals(a,b);
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,52,3,5,8};
        System.out.println(secondLargest(arr));
        System.out.println(Arrays.toString(firstHalf(arr)));
    }
}

