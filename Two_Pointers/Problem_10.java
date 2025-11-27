package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Character.isLetterOrDigit() -> Character.toLowercase(char) -> Life saver for this  question - Remind
public class Problem_10 {
//    Brute force with Edge cases based Update
    public static boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
//        Removing the special characters and spaces is the tricky part
        String sLower = s.toLowerCase();
        char[] sArray = sLower.toCharArray();

        List<Character> removedList = new ArrayList<>();
        List<Character> reversedList = new ArrayList<>();
//Numeric numbers allowed so 48 -> 57: a-z a from 97 to above
//        a-z = 97-122 0-9 = 47-58
        for(char a : sArray) {
            if(((int) a >= 97 && (int) a <= 122) || ((int) a > 47 && (int) a < 58)) {
               removedList.add(a);
            }
        }

        for(int j =removedList.size()-1; j >= 0; j--) {

            reversedList.add(removedList.get(j));
        }

        return removedList.equals(reversedList);
    }

//    Two Pointer solution
    public static boolean isPalindrome1(String s) {
        int left = 0;
        int right = s.length() - 1;

//        Until reaching the mid
        while(left < right) {
//            Keep moving left when it contains special character and keep checking left > right to not overlap
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
//            Keep moving right -- when it contains special character and keep checking left > right to not overlap
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome1(s);
        System.out.println(result);
        System.out.println((int) 'z');
    }
}
