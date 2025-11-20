import java.util.Arrays;
import java.util.HashMap;

public class Problem_2 {
//    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

//    Brute Force - Every character contains in both String
    public static boolean anagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
//        Let's sort the String
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        if(Arrays.equals(sArray, tArray)){
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean anagram2(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap1= new HashMap<>();
        HashMap<Character, Integer> hashMap2= new HashMap<>();

//         String s = "aabbbb", t = "aaaabb";


        char[] sArray = s.toCharArray(); // {a,a,b,b,b,b}
        char[] tArray = t.toCharArray(); // {a,a,a,a,b,b}

       for(char sChar : sArray) {
           if(hashMap1.containsKey(sChar)) {
               hashMap1.put(sChar, hashMap1.get(sChar) + 1);
           }
           else {
               hashMap1.put(sChar, 1);
           }

       }
        for(char tChar : tArray) { //{a,a,a,a,b,b}
            if(hashMap2.containsKey(tChar)) {
                hashMap2.put(tChar, hashMap2.get(tChar) + 1);
            }
            else{
                hashMap2.put(tChar, 1);
            }

        }

        for(char HashMap1Key : hashMap1.keySet()) {
            if(hashMap2.containsKey(HashMap1Key) && hashMap2.get(HashMap1Key).equals(hashMap1.get(HashMap1Key))) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;

    }

//    Optimal
    public static boolean anagram3(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];

        for(int i =0; i < s.length(); i++) {
            array[s.charAt(i) -97]++; //Increase the number +1 at the index of the array.
            array[t.charAt(i) -97]--;

        }
        for(int nums: array){
            if(nums != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabbbb", t = "aaaabb";
        System.out.println(anagram3(s,t));
    }
}
