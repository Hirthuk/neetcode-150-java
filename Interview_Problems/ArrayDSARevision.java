package Interview_Problems;

import java.util.*;

public class ArrayDSARevision {

    // 1. Find Largest Element
    static int largest(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            max = Math.max(max, num);
        return max;
    }

    // 2. Reverse an Array
    // Logic: Two pointers swap
    static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // 3. Second Largest Element
    static int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        return second;
    }

    // 4. Check if Array is Sorted
    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    // 5. Remove Duplicates from Sorted Array
    // Logic: Two pointers
    static int removeDuplicates(int[] arr) {
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }
        return index; // new length
    }

    // 6. Find Missing Number
    // Logic: Sum formula
    static int missingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr)
            actualSum += num;
        return expectedSum - actualSum;
    }

    // 7. Move Zeros to End
    static void moveZeros(int[] arr) {
        int index = 0;
        for (int num : arr) {
            if (num != 0)
                arr[index++] = num;
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    // 8. Pair with Given Sum
    // Logic: HashSet lookup
    static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num))
                return true;
            set.add(num);
        }
        return false;
    }

    // 9. Maximum Subarray Sum (Kadane's Algorithm)
    static int maxSubArraySum(int[] arr) {
        int currentSum = arr[0], maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // 10. Rotate Array by K Steps
    // Logic: Reverse array parts
    static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
