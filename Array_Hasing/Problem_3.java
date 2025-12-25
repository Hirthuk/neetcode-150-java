package Array_Hasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_3 {
    //    1. Two Sum
//        Given an array of integers nums and an integer target,
//        return indices of the two numbers such that they add up to target.

//    Brute force
    public static int[] twoSum(int[] nums,int target) {
        int [] resultArray;
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {};
    }

//    Some use cases Failing.
    public static int[] twoSum1(int[] nums, int target) {
        List<Integer> remains = Arrays.stream(nums).boxed().toList();

        for(int i=0; i < nums.length; i ++) {
            int remainValue = Math.abs(target - nums[i]);
            boolean remainIndex = remains.contains(remainValue);
            if( remainIndex && remains.indexOf(remainValue) != i ) {
                return new int[] {i,remains.indexOf((remainValue))};
            }
        }

        return new int[] {};
    }

//    Optiomal Solution
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // complement and index
        for(int i=0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment)) {
                return new int[] {i, map.get(compliment)};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        int[] result = twoSum1(array, 9);
        System.out.println(Arrays.toString(result));


    }
}
