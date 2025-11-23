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

//    Optimized solution is to use Priority Queue -> We need to store only k elements and based on the large occurrences
//    We will remove the least occurrences elements - Revise about how Priority queue works before revise

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0) +1);
        }

        Queue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

                // This is the custom comparator defining the heap's order.
// This expression returns:
// 1. A NEGATIVE value if map.get(a) < map.get(b).
//    - In a Min-Heap, a negative result means 'a' has higher priority (is "smaller") than 'b'.
//    - This ensures the element 'a' with the **lower frequency** is prioritized and placed closer to the root.
// 2. A POSITIVE value if map.get(a) > map.get(b).
//    - This means 'a' has lower priority than 'b'.
//    - This ensures the element 'a' with the **higher frequency** sinks down the heap.
// 3. ZERO if frequencies are equal.
//
// **RESULT:** This comparator creates a **Min-Heap based on frequency**.
// The element at the root (the one `poll()` removes) is always the element with the **least frequency**.

        for(int q : map.keySet()) {
            queue.add(q); // At first it won't compare -> then it will compare and add based on the frequency definition we set inside
            if(queue.size() > k) {
                queue.poll(); //Return the first priority element and removes it
            }
        }

        int[] ans = new int[k];
        for(int i=0; i <k; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }

    public static int[] practiceRepeat(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(
//                Ascending order
                (a,b) -> map.get(a) - map.get(b)
        );

        for(int n : map.keySet()) {
            queue.add(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int k = 10;
       int[] result = topKFrequent(nums,k);
       for(int num : result) {
           System.out.println(num);
       }
    }
}