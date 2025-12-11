package Array_Hasing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Probelm_1 {
    public static boolean containsDuplicate(int[] nums) {
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

//    Just sort them and if you don't find the same number next to it then it means that number not present at all.
public static boolean containsDuplicate2(int[] nums) {

    // Convert primitive int[] to List<Integer>
    List<Integer> numsList = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());

    // Sort the list
    List<Integer> sortedList = numsList.stream()
            .sorted()
            .collect(Collectors.toList());

    // Compare adjacent elements
    for (int i = 0; i < sortedList.size() - 1; i++) {
        if (sortedList.get(i).equals(sortedList.get(i + 1))) {
            return true;
        }
    }

    return false;
}

//Using Streams

    public static boolean containsDuplicate3(int[] nums) {
        return Arrays.stream(nums).boxed().distinct().count() != nums.length;
//        Sorted the elements in the array -> distinct will remove the repetitive elements right.. in that case..
//        It is going to reduce the length of the array so if it less means something common was there so true or false
    }

    public static boolean containsDuplicate4(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int n : nums) {
            if(hashSet.contains(n)) {
                return true;
            }
            hashSet.add(n);
        }
        return false;
    }
    public static void main(String[] args) {
//        217. Contains Duplicate
//        Brute force
        int nums[] = {1,2,3,4};
//        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate2(nums));

    }
}
