package Interview_Problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

//    Join a list of strings into a single comma-separated string.
    public static String joinString(List<String> list) {
        StringBuilder sb = new StringBuilder();

        list.stream().forEach((element) -> {
            sb.append(element).append(',');
        });

        return sb.toString();
    }

//    Square each number in a list and collect the result.
    public static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream().map((element) -> element * element).collect(Collectors.toList());
    }
//    Partition a list of integers into even and odd numbers.
    public static List<List<Integer>> oddEven(List<Integer> list) {
        List<Integer> odd = list.stream().filter((element) -> element % 2 != 0)
                .collect(Collectors.toList());
        List<Integer> even = list.stream().filter((element) -> odd.indexOf(element) == -1).
                collect(Collectors.toList());

//        Better way to use GroupingBy or Partitioning by for use case like this with two possiblity
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

          return new ArrayList<>(map.values());
//        return List.of(odd, even);
    }

//    Group a list of strings by their length.
    public static List<List<String>> groupStringByLength(List<String> list) {
        Map<Integer, List<String>> map = new HashMap<>();

        list.stream().forEach(
                (element) -> {
                    if(map.containsKey(element.length())) {
                        map.get(element.length()).add(element);
                    }
                    else{
                        map.put(element.length(), new ArrayList<>());
                        map.get(element.length()).add(element);
                    }
                }
        );

//      Better Way
        Map<Integer, List<String>> result = list.stream().collect(Collectors.groupingBy(String:: length));


        return new ArrayList<>(result.values());
    }

//    Check whether a given string is a palindrome using Stream API.
    public static boolean checkPalindrome(String s) {
        String result = s.toLowerCase();
        return IntStream.range(0, result.length() / 2)
                .allMatch( i -> result.charAt(i) == result.charAt(result.length() - 1 - i));


    }

    public static void main(String[] args) {
        int[] numArray = {1,29,3,4,4,5,6, 102};
        List<Integer> list = Arrays.stream(numArray).boxed().collect(Collectors.toList());
        List<String> StringList = List.of("Sharan", "Thippu", "Priyan1");
        String s = "Gayathri Kollipara";
        String palindrome = "Mamuu";
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
        System.out.println(joinString(StringList));
        System.out.println(squareNumbers(list));
        System.out.println(oddEven(list));
        System.out.println(groupStringByLength(StringList));
        System.out.println(checkPalindrome(palindrome));

    }
}
