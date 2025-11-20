import java.util.*;
import java.util.stream.Collectors;

public class Problem_4 {
//Group Anagrams
//    With Java 8 Features it is going simple
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<String> list = Arrays.asList(strs);

        Map<String, List<String>> grouped = list.stream().collect(Collectors.groupingBy(
                str -> {
                    char[] a = str.toCharArray();
                    Arrays.sort(a);
                    return new String(a);
                }
        ));

        List<List<String>> result = new ArrayList<>(grouped.values());


        return result;
    }

//    Optimal Solution
    public static List<List<String>> groupAnagrams2(String[] strs) {
//        Let's create key and add elements
      Map<String, List<String>> map = new HashMap<>();

      int count[] = new int[26];

      for(String s: strs) {
          Arrays.fill(count, 0);


          for(char a : s.toCharArray()) {
              count[a -'a'] ++; //abc looks like 111000 -> 26
          }
          StringBuilder sb = new StringBuilder();
//        Storing in mutable string
          for(int i=0; i < count.length; i++) {
              sb.append('#'); //for uniqueness between values
              sb.append(count[i]);
          }

          String key = sb.toString();
          if(!map.containsKey(key)) {
              map.put(key, new ArrayList<>());
          }
//          Accessing the particular array list and adding that element
          map.get(key).add(s);

      }
      return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
