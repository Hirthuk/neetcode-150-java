package interview_capegemini;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Given a
// list of strings, write a program to count the number of strings containing a specific character ‘a’ using Java Stream API.
//List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "kiwi", "lemon");
public class Problem1 {
    public static int problem1() {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "kiwi", "lemon");
        List<String> resultList = strings.stream().filter((string) -> string.indexOf('a') != -1).collect(Collectors.toList());
        return resultList.size();

    }

//    Write a method checkString(String name), call the method by passing null
//    and check if name is not null then print name ELSE print the message "null value is not allowed".
//            (Use Optional Class).

    public static String checkString(String name) {
        Optional<String> result = Optional.ofNullable(name);

        if(!result.isPresent()) {
            return "null value is not allowed";
        }
        return "It is not Null";
    }

    public static void main(String[] args) {
        System.out.println(problem1());
        System.out.println(checkString("Sharan"));
    }

}
