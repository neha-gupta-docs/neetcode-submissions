// You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

// Each row must contain the digits 1-9 without duplicates.
// Each column must contain the digits 1-9 without duplicates.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
// Return true if the Sudoku board is valid, otherwise return false

// Note: A board does not need to be full or be solvable to be valid.

// Input: board =
// [["1","2",".",".","3",".",".",".","."],
//  ["4",".",".","5",".",".",".",".","."],
//  [".","9","8",".",".",".",".",".","3"],
//  ["5",".",".",".","6",".",".",".","4"],
//  [".",".",".","8",".","3",".",".","5"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".",".",".",".",".",".","2",".","."],
//  [".",".",".","4","1","9",".",".","8"],
//  [".",".",".",".","8",".",".","7","9"]]

// Output: true

// Input: board =
// [["1","2",".",".","3",".",".",".","."],
//  ["4",".",".","5",".",".",".",".","."],
//  [".","9","1",".",".",".",".",".","3"],
//  ["5",".",".",".","6",".",".",".","4"],
//  [".",".",".","8",".","3",".",".","5"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".",".",".",".",".",".","2",".","."],
//  [".",".",".","4","1","9",".",".","8"],
//  [".",".",".",".","8",".",".","7","9"]]

// Output: false

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.

// SOLUTION 1 - HASHSET ( ONE PASS )
  // Time complexity : O(n2)
  // Space complexity : O(n2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();

        for(int row = 0; row < board.length ; row++) {
            for(int column=0; column < board[0].length; column++) {

                if(board[row][column]=='.') {
                    continue;
                }

                String squareKey = (row/3) + "," + (column/3);

                if(rowMap.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][column]) ||
                   columnMap.computeIfAbsent(column, k -> new HashSet<>()).contains(board[row][column]) ||
                   squareMap.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[row][column])) {
                    return false;
                   }

                rowMap.get(row).add(board[row][column]);
                columnMap.get(column).add(board[row][column]);
                squareMap.get(squareKey).add(board[row][column]);

            }
            
        }
        return true;
    }
}


// SOLUTION 2 : BITMASK

  // Time complexity : O(n2)
  // Space complexity : O(n)

// public class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         int[] rows = new int[9];
//         int[] cols = new int[9];
//         int[] squares = new int[9];

//         for (int r = 0; r < 9; r++) {
//             for (int c = 0; c < 9; c++) {
//                 if (board[r][c] == '.') continue;

//                 int val = board[r][c] - '1';

//                 if ((rows[r] & (1 << val)) > 0 || (cols[c] & (1 << val)) > 0 ||
//                     (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0) {
//                     return false;
//                 }

//                 rows[r] |= (1 << val);
//                 cols[c] |= (1 << val);
//                 squares[(r / 3) * 3 + (c / 3)] |= (1 << val);
//             }
//         }
//         return true;
//     }
// }