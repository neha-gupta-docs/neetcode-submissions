class Solution {
    public boolean exist(char[][] board, String word) {

        for(int row=0; row < board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                if(findWord(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int index, int row, int col) {

        if(index == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        if(board[row][col] == '#') {
            return false;
        }

        char curr = board[row][col];
        board[row][col] = '#';
        boolean found = findWord(board, word, index+1, row+1, col) || findWord(board, word, index+1, row-1, col) || findWord(board, word, index+1, row, col+1) || findWord(board, word, index+1, row, col-1);
        board[row][col] = curr;

        return found;
    }
}
