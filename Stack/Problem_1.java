package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Valid Paranthesis
public class Problem_1 {
    public boolean isValid(String s) {

        if(s.length() == 0 || s.length() == 1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }

            else{
                if(stack.isEmpty()) {
                    return false;
                }
                char topElement = stack.pop();
                if(c == '}' && topElement != '{'){
                    return false;
                }
                if(c == ')' && topElement != '('){
                    return false;
                }
                if(c == ']' && topElement != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
