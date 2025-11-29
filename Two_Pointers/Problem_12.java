package Two_Pointers;

import java.sql.Array;
import java.util.*;

public class Problem_12 {
//    Brute Force approach
//    Triplet addition = 0; different indices -> In the found triplets pairing should be unique
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
//        Using Set to ignore duplication ArrayList
//        Since j is i+1 and k is j+1 Indexes going to be distinct
        for(int i =0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                       List<Integer> listTriplet = new ArrayList<>();
                       listTriplet.add(nums[i]);
                       listTriplet.add(nums[j]);
                       listTriplet.add(nums[k]);
//                       Sorting to make in order so Set can find if it is duplicate.
                       Collections.sort(listTriplet);
                       set.add(listTriplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

//    Optimal Solution - 1 - Time Limit Exceeded
    public static List<List<Integer>> threeSum1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> setList = new HashSet<>();
//        // Map value -> its last index (so duplicates map to the last occurrence)
        for(int i=0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                int compliment = -(nums[i] + nums[j]);
                Integer indexOfCompliment = map.get(compliment);
//                Condition - Indexes of the element should be different
                if(indexOfCompliment != null && indexOfCompliment != i && indexOfCompliment != j) {
                    List<Integer> trip = Arrays.asList(nums[i], nums[j], compliment);
                    Collections.sort(trip); //So all the elements inside list will be same order..
//                    Set will add unique elements based on that
                    System.out.println(trip.toString());
                    setList.add(trip);
                }
            }
        }
        return  new ArrayList<>(setList);
       }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i < nums.length; i++) {
//            We will skip doing things if the same element comes again.
//            If we take the same element duplicate triplet will come.
//            Since we have sorted the array similar element will be near to it
//            For first element there won't be previous so i > 0
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
//            After i left element
             int left = i+1;
//            Last element is right
             int right = nums.length -1;
//           Until Left and right did not cross i will be same
             while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
//                Sum is less so increase the left to increase the sum
                if(sum < 0) {
                    left++;
                }
//                Greater than zero so reduce it
                else if(sum > 0) {
                    right --;
                }
//                Else sum is 0 so it is triplet
                else{
//                    Elements inside it will be sorted already because we are adding in sorted array from i left right
                    List<Integer> list = Arrays.asList(nums[i], nums[left],nums[right]);
                    result.add(list);
//                    Once I found it I don't need to check on that left and right
                    left++;
                    right--;
//                    Once we found that we will check that reduce left and added right shouldn't be same.. again same triplet will come
//                    So we will keep reducing until it's same number also it don't cross left and right
                    while(left < right && nums[left] == nums[left -1]) {
                        left++;
                    }
//                    Here right will be added becuase after index will be checked naa before
                    while(left < right && nums[right] == nums[right+1]) {
                        right--;
                    }

                }
             }


        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum2(nums);
        System.out.println("My Result " + list.toString());
        System.out.println("Expected Result " + "[[-1,-1,2],[-1,0,1]]");

    }

}
