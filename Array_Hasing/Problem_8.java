package Array_Hasing;

import java.util.HashSet;
import java.util.Set;

public class Problem_8 {
//    Brute Force seems real to Optimal with Slight Variation.. so far this is good may be.
    public static boolean isValidSudoku(char[][] board) {

//        Same row same element check
        for(int i=0; i < board.length; i ++) {
            Set<Character> tracker = new HashSet<>(9);
            for(int j=0; j < board.length; j++) {
                char currentChar = board[i][j];
                if(currentChar != '.') { // We are Skipping adding .
                    if(tracker.contains(currentChar)) {
                        return false;
                    }
                    else{
                        tracker.add(currentChar);
                    }
                }
            }
        }

//        Column check
//        Just reverse it indexes inside the double array\
        for(int i =0; i < board.length; i++) {
            Set<Character> hashSet = new HashSet<>(9);
            for(int j=0; j < board.length; j++) {
                char currentChar = board[j][i];
                if(currentChar != '.') {
                    if(hashSet.contains(currentChar)) {
                        return false;
                    }
                    else{
                        hashSet.add(currentChar);
                    }
                }
            }
        }

//        Box Check
//        Total of 9 3 set boxes - 0, 8 based on Index
        for(int box = 0; box < 9; box++) {
            Set<Character> boxTest = new HashSet<>(9);
            for(int row = 0; row < 3; row++) {
                for(int col=0; col < 3; col++) {
//                    This is the logic to check the boxes... How this Traversal works see below
                    int currentRow = (box/3)*3+row;
                    int currentColumn = (box % 3)*3+col;
                    if(board[currentRow][currentColumn] == '.') {
                        continue;
                    }
                    if(boxTest.contains(board[currentRow][currentColumn])) {
                        return false;
                    }
                    else{
                        boxTest.add(board[currentRow][currentColumn]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'1','2','4','.','3','.','.','.','.'},
                {'0','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'9','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.print("Sudoku" + isValidSudoku(board));
    }
}

//BOX 0 → rows 0–2, cols 0–2
//        (0,0) (0,1) (0,2)
//        (1,0) (1,1) (1,2)
//        (2,0) (2,1) (2,2)

//BOX 1 → rows 0–2, cols 3–5
//        (0,3) (0,4) (0,5)
//        (1,3) (1,4) (1,5)
//        (2,3) (2,4) (2,5)
//
//BOX 2 → rows 0–2, cols 6–8
//        (0,6) (0,7) (0,8)
//        (1,6) (1,7) (1,8)
//        (2,6) (2,7) (2,8)
//
//BOX 3 → rows 3–5, cols 0–2
//        (3,0) (3,1) (3,2)
//        (4,0) (4,1) (4,2)
//        (5,0) (5,1) (5,2)
//
//BOX 4 → rows 3–5, cols 3–5
//        (3,3) (3,4) (3,5)
//        (4,3) (4,4) (4,5)
//        (5,3) (5,4) (5,5)
//
//BOX 5 → rows 3–5, cols 6–8
//        (3,6) (3,7) (3,8)
//        (4,6) (4,7) (4,8)
//        (5,6) (5,7) (5,8)
//
//BOX 6 → rows 6–8, cols 0–2
//        (6,0) (6,1) (6,2)
//        (7,0) (7,1) (7,2)
//        (8,0) (8,1) (8,2)
//
//BOX 7 → rows 6–8, cols 3–5
//        (6,3) (6,4) (6,5)
//        (7,3) (7,4) (7,5)
//        (8,3) (8,4) (8,5)
//
//BOX 8 → rows 6–8, cols 6–8
//        (6,6) (6,7) (6,8)
//        (7,6) (7,7) (7,8)
//        (8,6) (8,7) (8,8)
