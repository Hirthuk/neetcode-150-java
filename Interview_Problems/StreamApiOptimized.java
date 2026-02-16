package Interview_Problems;

import java.util.*;
import java.util.stream.*;

public class StreamApiOptimized {

    // 1. Find Maximum Element
    public static int maxElement(int[] input) {
        return Arrays.stream(input)
                .max()
                .orElseThrow();
    }

    // 2. Find Minimum Element
    public static int minElement(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();
    }

    // 3. Calculate Sum of All Numbers
    public static int sumElement(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 4. Find Average
    public static double averageStream(int[] input) {
        return Arrays.stream(input)
                .average()
                .orElse(0.0);
    }

    // 5. Count Even Numbers
    public static long countEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }

    // 6. Remove Duplicates (Maintain Order)
    public static List<Integer> removeDuplicate(List<Integer> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    // 7. Sort Ascending
    public static List<Integer> sortList(List<Integer> list) {
        return list.stream()
                .sorted()
                .toList();
    }

    // 8. Sort Descending
    public static List<Integer> sortDescList(List<Integer> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // 9. Second Largest Element
    public static int secondLargestElement(List<Integer> list) {
        return list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
    }

    // 10. Check if Any Number > 100
    public static boolean checkGreaterThan100(List<Integer> list) {
        return list.stream()
                .anyMatch(n -> n > 100);
    }

    // 11. Convert to Uppercase
    public static List<String> convertUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .toList();
    }

    // 12. Character Frequency
    public static Map<Character, Long> frequency(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
    }

    // 13. First Non-Repeating Character
    public static Character firstNonRepeatingCharacter(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    // 14. Find Duplicate Elements
    public static List<Character> findDuplicateElements(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    // 15. Find Longest String
    public static String findLongestString(List<String> list) {
        return list.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    // 16. Join Strings with Comma
    public static String joinString(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(","));
    }

    // 17. Square Each Number
    public static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .toList();
    }

    // 18. Partition Even and Odd
    public static Map<Boolean, List<Integer>> oddEven(List<Integer> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // 19. Group Strings by Length
    public static Map<Integer, List<String>> groupStringByLength(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // 20. Check Palindrome Using Stream
    public static boolean checkPalindrome(String s) {
        String result = s.toLowerCase();
        return IntStream.range(0, result.length() / 2)
                .allMatch(i ->
                        result.charAt(i) ==
                                result.charAt(result.length() - 1 - i)
                );
    }


    // MAIN METHOD FOR TESTING
    public static void main(String[] args) {

        int[] numArray = {1, 29, 3, 4, 4, 5, 6, 102};
        List<Integer> list = Arrays.stream(numArray).boxed().toList();
        List<String> stringList = List.of("Sharan", "Thippu", "Priyan1");
        String s = "programming";
        String palindrome = "Mamuu";

        System.out.println(maxElement(numArray));
        System.out.println(minElement(list));
        System.out.println(sumElement(list));
        System.out.println(averageStream(numArray));
        System.out.println(countEven(list));
        System.out.println(removeDuplicate(list));
        System.out.println(sortList(list));
        System.out.println(sortDescList(list));
        System.out.println(secondLargestElement(list));
        System.out.println(checkGreaterThan100(list));
        System.out.println(convertUpperCase(stringList));
        System.out.println(frequency(s));
        System.out.println(firstNonRepeatingCharacter(s));
        System.out.println(findDuplicateElements(s));
        System.out.println(findLongestString(stringList));
        System.out.println(joinString(stringList));
        System.out.println(squareNumbers(list));
        System.out.println(oddEven(list));
        System.out.println(groupStringByLength(stringList));
        System.out.println(checkPalindrome(palindrome));
    }
}
