package Interview_Problems;

import java.util.*;

public class StringDSARevision {

    // 1. Reverse a String
    // Logic: Convert to char array and swap using two pointers
    static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    // 2. Check Palindrome
    // Logic: Compare characters from start and end
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    // 3. Count Vowels and Consonants
    static void countVowelsAndConsonants(String s) {
        int vowels = 0, consonants = 0;
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    // 4. Reverse Words in a String
    // Logic: Split by space and traverse from end
    static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    // 5. First Non-Repeating Character
    // Logic: Frequency map + second traversal
    static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return '\0';
    }

    // 6. Check Anagram
    // Logic: Character frequency comparison
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }

    // 7. Remove Duplicate Characters
    // Logic: HashSet maintains uniqueness
    static String removeDuplicates(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for (char c : s.toCharArray())
            set.add(c);

        StringBuilder sb = new StringBuilder();
        for (char c : set)
            sb.append(c);

        return sb.toString();
    }

    // 8. Longest Word in a Sentence
    static String longestWord(String s) {
        String[] words = s.split(" ");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }
        return longest;
    }

    // 9. String Compression
    // Logic: Count consecutive characters
    static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }

//    Alternate
    static String compressString1(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int count = 1;

            // count repeating characters
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(s.charAt(i)).append(count);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    // 10. Longest Substring Without Repeating Characters
    // Logic: Sliding Window + HashSet
    static int longestUniqueSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
