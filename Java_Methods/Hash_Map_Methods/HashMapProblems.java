package Java_Methods.Hash_Map_Methods;

import java.util.*;

public class HashMapProblems {

    // HM1 - character frequency
    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        return map;
    }

    // HM2 - first non-repeating character
    public static Character firstNonRepeating(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>(); //To Keep the Order - Important
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> frequecyMap: map.entrySet()) {
            if(frequecyMap.getValue() == 1){
                return frequecyMap.getKey();
            }
        }
        return null;
    }

    // HM3 - ransom note check
    public static boolean canForm(String ransom, String magazine) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char c : magazine.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        for(char c : ransom.toCharArray()) {
            if(!frequencyMap.containsKey(c) || frequencyMap.get(c) == 0){
                return false;
            }
            else{
                frequencyMap.put(c,frequencyMap.get(c) - 1);
            }
        }
        return true;
    }

    // HM4 - group anagrams
    public static Map<String, List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: words) {
           char[] sArray = s.toCharArray();
           Arrays.sort(sArray);
           String sorted = new String(sArray);

           if(map.containsKey(sorted)){
               map.get(sorted).add(s);
           }
           else{
               map.put(sorted, new ArrayList<String>());
               map.get(sorted).add(s);
           }

        }
        return  map;
    }

    // HM5 - update score only if higher
    public static void updateScore(Map<String, Integer> scores, String name, int newScore) {
//        if(newScore > scores.get(name)){
//            scores.put(name, newScore);
//        } //If the Key is absent we will get the NullPointer exception - getOrDefault
        scores.put(name,
                Math.max(scores.getOrDefault(name, 0), newScore));
    }

    public static void main(String[] args) {
        // test all methods
        System.out.println(charFrequency("SharanKumar"));
        System.out.println(firstNonRepeating("harankumar"));
        System.out.println(canForm("Shaa","harankumar"));
        String[] words = {"Sharan", "Sharan", "tan", "nat","Thippu"};
        System.out.println(groupAnagrams(words));
    }
}
