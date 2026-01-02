package Java_Methods.String_Methods;

import java.util.*;

public class StringProblems {
//    Count vowels in a string (charAt, length)

//    Problem 1
    public static int findVowels(String s) {
//      Methods used -> Length, charAt(), toLowerCase()
        String lowerCase = s.toLowerCase();
        int count = 0;
        for(int i=0; i < s.length(); i++) {
            char currentCharacter = lowerCase.charAt(i);
            if(currentCharacter == 'a' || currentCharacter == 'e' ||
                    currentCharacter == 'i' || currentCharacter == 'o' || currentCharacter == 'u'){
                count++;
            }
        }
        return count;
    }

//    Problem 1 - Optimal Solutions
    public static int findVowels1(String s) {
//      Methods used String.indexOf(char c)
        String str = s.toLowerCase();
        int count = 0;
        for(char c: s.toCharArray()) {
            if("aeiou".indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }
//    Problem - 2 Reverse words in the Sentence
    public static String reverseSentence(String s){
//        Methods used - Split, join
        String[] split = s.split(" ");
        String[] reversed = new String[split.length];
        int count = 0;
        for(int i= split.length - 1; i >= 0; i--) {
            reversed[i] = split[count];
            count++;
        }
        String result = String.join(" ",reversed).trim();
        return result;
    }

//    Problem -2 - OPtimal solution
    public static String reverseSentence1(String s){
//        Methods used - trim(), split(), String.join(delimiter, String[] array), Arrays.asList()
       String[] sArray = s.trim().split(" ");
       Collections.sort(Arrays.asList(sArray));
       return String.join(" ", sArray);
    }

//    Problem - 3 Remove duplicate characters
    public static String removeDuplicate(String s) {
//      Methods used : toCharArray()
        char[] sArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : sArray) {
            set.add(c); //Don't keep the order
        }
        StringBuffer sb = new StringBuffer();
        for(char c : set) {
            sb.append(c);
        }
        return new String(sb);
    }

//  Problem - 3 Optimal solution
    public static String removeDuplicate1(String s) {
//      Use LinkedHashSet to keep the same order
        Set<Character> set = new LinkedHashSet<>();
        for(char c: s.toCharArray()) {
            set.add(c);
        }
        StringBuffer sb = new StringBuffer();
        for(char c: set) {
            sb.append(c);
        }

        return new String(sb);
    }

//  Problem - 3 Optimal solution 2 without extra DS
    public static String removeDuplicate2(String s) {
//
        boolean[] seen = new boolean[256]; //array of boolean with 256 character ASCII code-
//         By default, all values are false
        StringBuffer sb = new StringBuffer();
        for(char c: s.toCharArray()){
            if(!seen[c]){ //If value not present make it true. so next time won't be added also
//                add to the sb.
                seen[c] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    Problem - 4 - Anagram
    public static boolean anagram(String s, String t) {
//      Methods Used toCharArray, Arrays.sort(), Arrays.equals(arr1, arr2)
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);

    }

//  Best Optimal solution without extra Data structure;
    public static boolean anagram1(String s, String t) {
//        Just for practice
        if(s.length() != t.length()) {
            return false;
        }
        int[] frequency = new int[26]; //By Default all elements will be 0

        for(int i=0; i < s.length();i++){
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        for(int i : frequency){
            if(i < 0){
                return false;
            }
        }

        return true;
}
//    Problem - 5 CompressString
    public static String compressString(String s) {
        //aabbcdd -> a2b2c1d2
//      Methods Used keySet() from map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : s.toCharArray()){
           frequencyMap.put(c, frequencyMap.getOrDefault(c,0) + 1);
        }
        StringBuffer sb = new StringBuffer();
        for(Character c : frequencyMap.keySet()) {
            sb.append(c);
            sb.append(frequencyMap.get(c));
        }
        return new String(sb);
    }

//  Problem -5 Optimal solution - Use LinkedHashMap to maintain order.
    public static String compressString1(String s) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for(char c: s.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c,0) + 1);
        }

        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer> entry: frequencyMap.entrySet()){
            sb.append(entry.getKey());
            sb.append(entry.getKey());
        }

        return sb.toString();
    }

//  Problem - 5 Best use case without extra DS
    public static String compressString2(String s){
        StringBuffer sb = new StringBuffer();
        int count = 1;

        for(int i=1; i < s.length(); i++){
            if(i< s.length() && s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                sb.append(s.charAt(i)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Sharankumar";
        System.out.println("Find Vowels " + findVowels1(s));
        String sentence = "Sharankumar is a good boy in HCL";
        System.out.println("Reverse a Sentence " + reverseSentence(sentence));
        System.out.println("Remove Duplicates " + removeDuplicate(s));
        System.out.println("Compress String "+ compressString2(s));
    }
}
