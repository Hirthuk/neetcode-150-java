package Sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Longest Repeating Character Replacement
public class Problem_17 {
//  AAABABB
//  Brute Force approach
    public static int characterReplacement(String s, int k) {
        int result = 0;
        for(int i =0; i < s.length(); i++){
            Map<Character, Integer> countFrequency = new HashMap<>();
            int maxCountOfElement = 0;
            for(int j=i; j < s.length();j++) {
                countFrequency.put(s.charAt(j), countFrequency.getOrDefault(s.charAt(i), 0) + 1);
                maxCountOfElement = Math.max(maxCountOfElement, countFrequency.get(s.charAt(j)));
                if((j- i + 1) - maxCountOfElement <= k){
                    result =  Math.max(result, j-i + 1);
                }
            }
        }
        return result;
    }

    public static int characterReplacement1(String s, int k) {
       int result = 0;
       HashSet<Character> uniqueElements = new HashSet<>();

       for(char c: s.toCharArray()) {
           uniqueElements.add(c);
       }

       for(char c: uniqueElements) {
           int left = 0;
           int count = 0;

           for(int right =0; right < s.length(); right++) {
               if(s.charAt(right) == c) {
                   count++;
               }

               while(right-left - count > k) {
                   if(s.charAt(left) == c){
                       count--;
                   }
                    left++;
               }


               result = Math.max(right-left, result);
           }
       }
       return result;
    }

    public static int characterReplacement2(String s, int k) {
        Map<Character, Integer> frequency = new HashMap<>();
        int left = 0;
        int MaximumFrequency = 0;
        int result = 0;

        for(int right =0; right < s.length();right++) {
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);
            MaximumFrequency = Math.max(frequency.get(s.charAt(right)), MaximumFrequency);

            while(right - left + 1 - MaximumFrequency > k){
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);

        }
        return result;
    }

}
