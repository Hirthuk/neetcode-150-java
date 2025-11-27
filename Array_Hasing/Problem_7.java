package Array_Hasing;

public class Problem_7 {

//    Brute Force - This is O(n^2) but requirement is O(n) ->Time Limit Exceeded
//    [1,2,3]
    public static int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        for(int i =0; i < nums.length; i ++) {
            int track = 1;
            for(int j =0; j < nums.length; j++) {
                if(i != j) {
                    track = track * nums[j];
                }
            }
            result[i] = track;
        }

        return result;
    }

//    We shouldn't use division mentioned in the question if we can use that will be simple
//This won't work when the any value contains 0
    public static int[] productExceptSelf1 (int[] nums) {
        int track = 1;
        int zeroTrack = 1;
        int[] result = new int[nums.length];
        for(int i =0; i < nums.length; i ++) {
            track = track*nums[i];
        }

        for(int i=0; i < nums.length; i ++) {

            result[i] = track / nums[i];


        }

        return result;
    }

//    Optimal solution - Still don't fully get it yet.
    public static int[] productExceptSelf2(int[] nums) {
//   Complex to Understand moving to next
            int n = nums.length;
            int[] res = new int[n];

            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            for(int num : res) {
                System.out.println("Here " + num);
            }
            int postfix = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= postfix;
                postfix *= nums[i];
            }
            return res;


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf2(nums);
        for(int num : result) {
            System.out.println(num);
        }
    }
}
