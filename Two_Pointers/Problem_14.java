package Two_Pointers;

import java.util.Arrays;

public class Problem_14 {
// Problem Number - 42 Trapping Rain Water
//        Brute Force Approach - Water stores only between the Taller left and Taller right building of the
//        Current building. Also Water will store in the length of only the smallest of the Taller right and
//        Taller left building so that.. remaining height will go off the street.
//        Formula to find out is For each position, the water trapped above it depends on the tallest bar to its left and the tallest bar to its right.
//If we know these two values, the water at index i is:
//min(leftMax, rightMax) - height[i] Removing the building height since it won't store(no Gap)
    public static int trap(int[] height) {

            if(height.length == 0) {
                return 0;
            }
            int count = height.length;
            int result = 0;

            for(int i=0; i < count; i++) {
//            Setting from the left and right from the index building
                int leftMax = height[i];
                int rightMax = height[i];

//          Going from left until i to find the Max building height to the full left side of i
                for(int j=0; j < i; j++) {
                    leftMax = Math.max(leftMax, height[j]);
                }

//          Going from right after i until last(n) to find the Max building height to the full right side of i
                for(int j = i+1; j < count; j++) {
                    rightMax = Math.max(rightMax, height[j]);
                }


                result = result + Math.min(leftMax, rightMax) - height[i];
            }
            return result;
        }
//  Optimal Approach - Instead of checking each Left and Right Max for each index. We can compute it before and do
    public static int trap1(int[] height)  {

        if(height.length == 0) {
            return 0;
        }
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        leftMax[0] = height[0];
        for(int i =1; i < length; i++) {
//            Keep checking the previous Left Max height and updating it
            leftMax[i] = Math.max(leftMax[i -1], height[i]);
        }
        System.out.println(Arrays.toString(leftMax));
        rightMax[length -1] = height[length -1];
        for(int i = length -2; i >= 0; i-- ) {
            rightMax[i] = Math.max(rightMax[i +1], height[i]);
        }
        System.out.println(Arrays.toString(rightMax));

        int result = 0;
        for(int i=0; i < length; i++) {
            result = result + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;

    }

    public static void main(String[] args) {
        int[] height={0,2,0,3,1,0,1,3,2,1};
        System.out.println(Arrays.toString(height));
        int result = trap1(height);
        System.out.println(result);


    }
}
