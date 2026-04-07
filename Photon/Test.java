package Photon;

import java.util.*;

public class Test {

    public static int[] test1(int[] nums) {
        int[] array = new int[nums.length];
        int value = 1;
        for(int i=0; i < nums.length; i++) {
            for(int j=0; j < nums.length;j++) {
                if(i != j) {
                    value = value * nums[j];
                }

            }
            array[i] = value;
            value = 1;
        }
        return array;
    }

//    Example 1: Input: nums = [1,2,3,4] Output: [24,12,8,6]
    public static int[] test2(int[] nums) {
        int total = 1;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            else{
                total = total * nums[i];
            }

        }
        int[] result = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 0){
                result[i] = 0;
            }
            else{
                result[i] = total/nums[i];
            }

        }

        return result;
    }

    public static int[] test3(int[] nums) {
        Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i: nums) {
            list.add(i);
        }
        for(int i=0; i < nums.length; i++) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.set(i, 1);
            map.put(i, (ArrayList<Integer>) list1);
        }
        int[] result = new int[nums.length];

        map.forEach((a, d) -> {
           result[a] = map.get(a).stream().reduce(1,(c,b) -> c*b);
        });


        return result;
    }

    public static int[] test4(int[] nums) {
        int[] result = new int[nums.length];
        result[0] =  1;
//        left
        for(int i=1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        //right
        int right = 1;
        for(int i = nums.length - 1; i >=0; i--) {
            result[i] = result[i] * right;
            right = right*nums[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4};
      System.out.println(Arrays.toString(test4(input)));
    }
}
