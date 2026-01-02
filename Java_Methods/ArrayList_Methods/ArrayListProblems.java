package Java_Methods.ArrayList_Methods;

import java.util.*;

public class ArrayListProblems {

    // AL1 - remove odd numbers
    public static List<Integer> removeOdd(List<Integer> list) {
//      Store first 10 Integers and then remove the odd numbers
//      Methods used list.subList(startIndex, endIndex)
        List<Integer> result = list.subList(0,9).stream().filter(
                i -> i%2==0
        ).toList();

        return result;
    }

    //Optimal with Using only ArrayList methods
    public static List<Integer> removeOdd1(List<Integer> list) {
        for(int i=0; i < list.size(); i++) {
            if(list.get(i) % 2 != 0){
                list.remove(i); //Once after removal Index shifting will happen.. So Next element i+1 will be i so i--
                i--;
            }
        }
        return list;
    }

    // AL2 - find all indexes of target
    public static List<Integer> findIndexes(List<Integer> list, int target) {
        List<Integer> result = list.stream().filter(i -> i == target).map(i -> list.indexOf(i)).toList();
        return result;
    }

//  Optimal with using ArrayList Methods
    public static List<Integer> findIndexes1(List<Integer> list, int target) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i < list.size(); i++) {
            if(list.get(i) == target){
                list.add(i);
            }
        }
        return result;
    }
    // AL3 - split list into 2 halves
    public static List<List<Integer>> split(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(list.subList(0, list.size()/2));
        result.add(list.subList(list.size()/2, list.size()));
        return result;

    }

    // AL4 - convert to array
    public static Integer[] convertToArray(List<Integer> list) {
        return list.toArray(new Integer[0]);
    }

    // AL5 - undo last action (remove last added)
    public static void undo(Stack<Integer> history, List<Integer> list) {
        list.add(10);
        history.add(10);

        list.remove(history.pop());
    }

//  Optimal Solution
    public static void undo1(Stack<Integer> history, List<Integer> list) {
        if(history.size() > 0) {
            list.remove(history.pop());
        }
    }

    public static void main(String[] args) {
        // create ArrayList + test each method
    }
}

