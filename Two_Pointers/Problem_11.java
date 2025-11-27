package Two_Pointers;

import java.util.HashMap;
import java.util.Map;

public class Problem_11 {
//    two-sum-ii-input-array-is-sorted - 167

//    Brute Force
//    Return index with addition of 1 - Requirement
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i < numbers.length; i++) {
            for(int j=i; j < numbers.length; j++) {
                if(i != j && numbers[i] + numbers[j] == target) {
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[] {0,0}; //Have exactly one result. Just put for return statement.
    }

//    Optimal Solution
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1,i + 1};
            }
            else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{0,0};
    }

//    Optimal Two Pointer Solution
    public int[] twoSum2(int[] numbers, int target) {
        int left =0;
        int right = numbers.length -1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[] {left + 1, right + 1};
            }
            else if(sum > target) {
                right --;
            }
            else {
                left++;
            }
        }
        return new int[] {0,0};
    }
}
