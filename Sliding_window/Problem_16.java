package Sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Problem_16 {
    //  Longest Substring Without Repeating Characters
//  Brute force Approach

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        for(int i=0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for(int j=i; j < s.length(); j++){
                if(charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
//      After break statement it will come here
            result = Math.max(result, charSet.size());
        }
        return result;
    }

//    Sliding Window concept -> https://www.youtube.com/watch?v=sQJ2KH1CWg4 - Keeping unique elements of window

    public int lengthOfLongestSubstring1(String s) {

        if(s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int end = 0;
        int result = 1;
        Set<Character> seen = new HashSet<>();
        while(end < s.length()) {
            char c = s.charAt(end);
            while(seen.contains(s.charAt(start))) { //Keep shrinking the window from start until it don't contain repating value
                seen.remove(c);
                start++;
            }
            seen.add(c);
            int currentMaxUniqueElements = end - start + 1;
            result = Math.max(currentMaxUniqueElements, result);
            end++;
        }
        return result;
    }

    //    Using HashMap to pinpoint the last occurence of the repeated element and move it to next with adding 1.
    public int lengthOfLongestSubstring2(String s) {
        int start = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            map.put(c, end);
            result = Math.max(result, end - start + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "xxxx";
        System.out.println(lengthOfLongestSubstring(s));
    }
}



