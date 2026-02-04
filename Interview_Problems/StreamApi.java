package Interview_Problems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {

//Find the maximum element from an int[] using Stream API.
    public static int maxElement(int[] input) {
        OptionalInt result = Arrays.stream(input).max();
        if(result.isPresent()) {
            return result.getAsInt();
        }
        return 0;
    }
//Find the minimum element from a list of integers.
    public static int minElement(List<Integer> list) {
        Optional<Integer> result = list.stream().min(Comparator.naturalOrder());
        OptionalInt result2 = list.stream().mapToInt(Integer:: intValue).min();
        if(result.isPresent()) {
            return result.get();
        }
        return 0;
    }
//Calculate the sum of all numbers in a list.
    public static int sumElement(List<Integer> list) {
        int result = list.stream().mapToInt(Integer :: intValue).sum();
        int result2 = list.stream().reduce(0, (a,b) -> a+b);
        return result;
    }
//Find the average of numbers in an array.
    public static double averageStream(int[] input) {
        double result =  Arrays.stream(input).sum();
        return result/ input.length;
    }
//Count how many even numbers are present in a list.
    public static int countEven(List<Integer> list) {
        int result = list.stream().filter(a -> a%2 == 0).collect(Collectors.toList()).size();
        return result;
    }

//Remove duplicate elements from a list while maintaining insertion order.
    public static List<Integer> removeDuplicate(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>();
        list.stream().forEach(a -> set.add(a));
        return set.stream().toList();
    }

//Sort a list of integers in ascending order using streams.
    public static List<Integer> sortList(List<Integer> list) {
        List<Integer> result = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return result;

    }

//Sort a list of integers in descending order.
    public static List<Integer> sortDescList(List<Integer> list) {
        List<Integer> result = list.stream().sorted(Comparator.reverseOrder()).toList();
        return result;
    }

//    Find the second-largest element in a list using streams.
    public static int secondLargestElement(List<Integer> list) {
        List<Integer> result = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return result.get(result.size() - 2);
    }

//    Check if any number is greater than 100 in a list.
    public static boolean checkGreaterThan100(List<Integer> list) {
        List<Integer> result = list.stream().filter(a -> a > 100).collect(Collectors.toList());
        if(result.size() > 0) {
            return true;
        }
        return false;
    }

//    Convert a list of strings to uppercase using Stream API.
    public static List<String> convertUpperCase(List<String> list) {
        List<String> result = list.stream().map(String:: toUpperCase).collect(Collectors.toList());
        return result;
    }

//    Count the frequency of each character in a given string.
    public static Map<Character, Integer> frequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        s.chars().forEach(a -> {
            map.put((char) a, map.getOrDefault((char) a, 0) + 1);
        });
        return map;
    }

//    Find the first non-repeating character in a string using streams.
    public static char firstNonRepeatingCharacter(String s) {
      OptionalInt result = s.chars().filter(a -> {
            char c = (char) a;
            return s.indexOf(c) == s.lastIndexOf(c);
        }).findFirst();

      return (char) result.getAsInt();
    }

//  Find all duplicate elements in a list.
    public static List<Character> findDuplicateElements(String s) {
       List<Character> list= s.chars().filter(a -> {
            char c = (char) a;
            return s.indexOf(c) != s.lastIndexOf(c);
        }).distinct().mapToObj(i -> (char) i).collect(Collectors.toList());

       return list;
    }

//    Find the longest string from a list of strings.
    public static String findLongestString(List<String> list) {
        Optional<String> result = list.stream().reduce
                ((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        if(result.isPresent()) {
            return result.get();
        }

        return "";
    }

    public static void main(String[] args) {
        int[] numArray = {1,29,3,4,4,5,6, 102};
        List<Integer> list = Arrays.stream(numArray).boxed().collect(Collectors.toList());
        List<String> StringList = List.of("Sharan", "Thippu", "Priyan1");
        String s = "Gayathri Kollipara";
        System.out.println(maxElement(numArray));
        System.out.println(minElement(list));
        System.out.println(averageStream(numArray));
        System.out.println(countEven(list));
        System.out.println(removeDuplicate(list));
        System.out.println(sortList(list));
        System.out.println(sortDescList(list));
        System.out.println(secondLargestElement(list));
        System.out.println(checkGreaterThan100(list));
        System.out.println(convertUpperCase(StringList));
        System.out.println(frequency(s));
        System.out.println(firstNonRepeatingCharacter(s));
        System.out.println(findDuplicateElements(s));
        System.out.println(findLongestString(StringList));

    }
}
