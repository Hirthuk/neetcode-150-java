package Photon;

import java.util.Arrays;

public class Test2 {
//    Input: nums = [1,2,3,4] Output: [24,12,8,6]

    public static int[] solution(int[] nums) {
        int count = nums.length;

        int result[] = new int[count];
        result[0] = 1;

//      left Product
        for(int i=1; i < count;i++) {
            result[i] = result[i -1] * nums[i -1];
        }

        int right = 1;

//      Right Product
        for(int i = count -1; i >=0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];

        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1,1,0,-3,3};
        int[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }
}
