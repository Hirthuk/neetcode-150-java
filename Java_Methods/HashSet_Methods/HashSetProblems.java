package Java_Methods.HashSet_Methods;

import java.awt.*;
import java.util.*;
import java.util.List;

//add() → uniqueness
//
//contains() → membership
//
//removeAll() → difference
//
//retainAll() → intersection
public class HashSetProblems {

    // HS1 - check duplicates
    public static boolean hasDuplicates(int[] arr) {
       Set<Integer> set = new HashSet<>();
       for(int i : arr){
           if(!set.add(i)){ //add() returns false in set when there is duplicate
               return false;
           }
       }
       return true;
    }

    // HS2 - unique elements, preserve order
    public static List<Integer> uniquePreserveOrder(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i : arr){
            set.add(i);
        }
        return new ArrayList<>(set);
    }

    // HS3 - intersection of two arrays
    public static Set<Integer> intersection(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        for(int i: a) {
            set1.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for(int i : b){
            if(set1.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    // HS4 - remove blocked users
    public static Set<String> removeBlocked(Set<String> active, Set<String> blocked) {
        for(String s : blocked) {
            if(active.contains(s)){
                active.remove(s);
            }
        }
//      Even simpler in build method
        active.removeAll(blocked); // Remove all the elements with the give collection;
        return active;
    }

    // HS5 - convert set to array
    public static Integer[] convertToArray(Set<Integer> set) {
        return set.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        // test all methods
    }
}
