package Java_Methods.StackQueue_Methods;

import java.util.*;

public class StackDequeProblems {
    //Deque - Last in First out.
    // ST1 - validate parentheses
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            }
            else if(c == '{') {
                stack.push('}');
            }
            else if(c == '[') {
                stack.push(']');
            }
            if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return true;
    }

    // ST2 - reverse ArrayList using Stack -
    public static List<Integer> reverseList(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for(int i : list) {
            stack.push(i);
        }

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    // ST3 - postfix evaluation -  "23*54*+"
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        for(char c : expr.toCharArray()) {
            if(Character.isDigit(c)) {
//             Convert digit char to digit int
                stack.push(c -'0');
            }
            else{
                int b = stack.pop(); //Second number will come first so first from stack is 2nd -b
                int a = stack.pop(); //First number added first to stack and so it will come in 2nd pop -> a

                if(c == '+') {
                    stack.push(a+b);
                }
                else if(c == '-'){
                    stack.push(a-b);
                }
                else if(c == '*'){
                    stack.push(a-b);
                }
                else if(c == '/'){
                    stack.push(a/b);
                }
            }
        }
        return stack.pop();
    }

    // ST4 - undo last operation
    public static void undo(Stack<Integer> history, List<Integer> list) {
        if(!history.isEmpty()){
            list.remove(history.pop());
        }
    }

    // ST5 - sliding window maximum
    public static int[] slidingWindowMax(int[] nums, int k) {
        // your code
        return null;
    }

    public static void main(String[] args) {
        // test all methods
        List<Integer> input = Arrays.asList(1,2,3,4,5,6);
        System.out.println(reverseList(input));
    }
}

