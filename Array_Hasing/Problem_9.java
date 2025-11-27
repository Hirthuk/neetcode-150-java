package Array_Hasing;

import java.util.*;

public class Problem_9 {
//    Longest Consecutive Sequence
//My Brute force approaches
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println("Sorted Array " + num);
        }
//       In case duplicate element it will think as consecutive elements to taking only distinct values
        int[] nonDuplicate = Arrays.stream(nums).distinct().toArray();
        for (int num : nonDuplicate) {
            System.out.println("Sorted Array removed Duplicate " + num);
        }
        System.out.println(nonDuplicate.length);
//       {9,1,4,7,3,-1,0,5,8,-1,6};
        int trackCount = 1;
        int currentCount = 1;
        for (int i = 0; i < nonDuplicate.length - 1; i++) {
            if (nonDuplicate[i] + 1 == nonDuplicate[i + 1]) {
                currentCount = currentCount + 1;
            }
            else{
                currentCount = 1;
            }

//         In case all the elements are consecutive else block will won't even go so we adding this add.
//         Even not continuous consecutive it is going to add another one  that is not an issue;
            trackCount = Math.max(trackCount, currentCount);
        }

            return trackCount;
        }

    public static int longestConsecutive1(int[] nums)  {

        if(nums.length == 1) {
            return 1;
        }
        if(nums.length == 0) {
            return 0;
        }
        int[] sortedNonDuplicate = Arrays.stream(nums).sorted().distinct().toArray();

        int currentCount = 1;
        int trackerCount = 1;

        for(int i=0; i < sortedNonDuplicate.length - 1; i++) {
            if(sortedNonDuplicate[i] + 1 == sortedNonDuplicate[i+1]) {
                currentCount++;
            }
            else {
                currentCount = 1;
            }
            trackerCount = Math.max(currentCount, trackerCount);
        }

        return trackerCount;
    }

//    Better approach Solutions - same as ours but distinct logic check by us
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        if(nums.length == 0) {
            return 0;
        }
        int trackResult = 1;
        int currentTrack = 1;

        Arrays.sort(nums);

        for(int i=0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            }
            else if(nums[i] + 1 == nums[i+1]) {
                currentTrack++;
            }
            else{
                currentTrack =1;
            }

            trackResult = Math.max(trackResult, currentTrack);
        }

        return trackResult;
    }

//    Optimal Solution
//    By Using HashSet which removes Duplicate and take O(1) - HashSet for retrieval
    public static int longestConsecutive3(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        if(nums.length == 0) {
            return 0;
        }

        Set<Integer> hashSet = new HashSet<>();
        int longestSub = 1;
//      Removes duplicate
        for(int num : nums) {
            hashSet.add(num);
        }

        for(int num : hashSet) {
//            Going to be checking num+1 element exist.. Since going to use .contains.. it will check all the elements
            if(hashSet.contains(num -1 )) {
                continue;
            }
//            we know that there is an element greater than num.. going to check the consecutive count
            else{
                int currentValue = num;
                int currentConsecutive = 1;
                while(hashSet.contains(currentValue + 1)) {
                    currentValue++;
                    currentConsecutive++;
                }

                longestSub = Math.max(longestSub, currentConsecutive);
            }

        }
        return longestSub;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int value = longestConsecutive(nums);
        System.out.println("answer " + value);
    } }

