package Sliding_window;

//Sliding Window Maximum
public class Problem_20 {

//    Brute force approach
    public static int[] SlidingMaximum(int[] nums, int k) {
        int[] result = new int[nums.length -k +1];
        for(int i=0; i < nums.length -k +1; i++){
            int max = nums[i];
            for(int j=i+1; j < i+k; j++){
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }
}
