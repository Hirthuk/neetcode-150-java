package Binary_search;

//Binary Search

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_27 {
//    Brute force approach
    public int search(int[] nums, int target) {
        for(int i=0; i < nums.length;i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
//    HashMap approach - O(N)
    public int search1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        if(map.containsKey(target)) {
            return map.get(target);
        }

        return -1;
    }

//    Using Build in Method - O(log N)
    public int search2(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if(result < 0) {
            return -1;
        }
        return result;
    }

}
