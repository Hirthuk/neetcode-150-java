import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Problem_5 {
//    347. Top K Frequent Elements
//The Best brutal force from the past 5 - Very tricky understand the question. Very brutal still done compared to first 5.
    public static int[] topKElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
//        {4,1,-1,2,-1,2,3}
        List<Integer> tracker = new ArrayList<>();

        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            tracker.add(mapEntry.getValue());
        }

        List<Integer> sortedTracker = tracker.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());


//        for (Integer i : sortedTracker) {
//
//            System.out.println(i);
//          System.out.println("Sorted Occurrences");
//        }
//        System.out.println("_____");
        for (Map.Entry<Integer, Integer> mapEntry1 : map.entrySet()) {
            System.out.println(mapEntry1.getKey() + " " + mapEntry1.getValue());
        }
//        System.out.println("_____");
        List<Integer> result = new ArrayList<>();

//            Have to add all the elements to the result from the associated key from the map value until k

        for(int i=0; i < k; i++) {
            if(result.size() < k) {
                for(Map.Entry<Integer,Integer> mapFinal : map.entrySet()) {
                    if(sortedTracker.get(i) == mapFinal.getValue()) {
                        result.add(mapFinal.getKey());
                    }
                }
            }
            else{
                break;
            }

        }

        return result.stream().mapToInt(Integer :: intValue).sorted().toArray();


    }
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int k = 10;
       int[] result = topKElements(nums,k);
       for(int num : result) {
           System.out.println(num);
       }
    }
}