import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_6 {

//    Encode and Decode Strings
//    Brute force approach
//    This brute force seems to be near to optimal Let's stick to this
    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        strs.stream().map((str) -> {
            StringBuilder sb = new StringBuilder(str);
            sb.append("-");
            return sb.toString().toCharArray();

        }).forEach((charArray) -> {
            string.append(charArray);
        });

        return string.toString();
    }



    public List<String> decode(String str) {
        char[] array = str.toCharArray();
        List<String> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char a : array) {
            if(a == '-') {
                resultList.add(sb.toString());
                sb.setLength(0);
            }
            else{
                sb.append(a);
            }
        }
        return resultList;
    }
    public static void main(String[] args) {
        Problem_6 problem6= new Problem_6();
        String[] stringArray = {"neet","code","love","you"};
        List<String> stringList = Arrays.stream(stringArray).toList();
        String encodeString = problem6.encode(stringList);
        System.out.println(encodeString);
        System.out.println(problem6.decode(encodeString));

    }
}
