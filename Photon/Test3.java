package Photon;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

//    Input : [1,2,3,4,5,6]
//
//    k=6

    public static List<List<Integer>> groupSum(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < nums.length; i++) {
            int sum = 0;
            List<Integer> tracker = new ArrayList<>();
            for(int j=i; j < nums.length; j++) {
                sum = sum + nums[j];
                tracker.add(nums[j]);
                if(sum == k) {
                    result.add(new ArrayList<>(tracker));
                    tracker.clear();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(groupSum(array, 6));
    }
}
