package Sliding_window;

import java.util.Arrays;

public class Problem_18 {

//    Permutation in String
//    Brute Force approach
    public static boolean checkInclusion(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);

        for(int i=0; i < s2.length() - s1.length() + 1; i++) {
            char[] currentElement = new char[s1.length()];
            int k = 0;
            for(int j=i; j < s1.length() + i; j++){
                currentElement[k] = s2.charAt(j);
                k++;
            }
            Arrays.sort(currentElement);
            if(Arrays.equals(s1Array, currentElement)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "leczbee";

        System.out.println(checkInclusion(s1, s2));
    }
}
