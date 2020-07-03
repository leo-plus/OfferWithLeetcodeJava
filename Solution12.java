class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || word.length() == 0) {
            return false;
        }

        int rowLen = board.length;
        int colLen = board[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                visited[row][col] = false;
            }
        }
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (existCore(board, row, col, visited, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean existCore(char[][] board, int rowIndex, int colIndex, boolean[][] visited, String word,
            int strIndex) {
        if (strIndex >= word.length()) {
            return true;
        }

        if (rowIndex < 0 || colIndex < 0 || rowIndex >= board.length || colIndex >= board[0].length) {
            return false;
        }

        if (visited[rowIndex][colIndex] == false && board[rowIndex][colIndex] == word.charAt(strIndex)) {
            visited[rowIndex][colIndex] = true;
            boolean result = existCore(board, rowIndex + 1, colIndex, visited, word, strIndex + 1)
                    || existCore(board, rowIndex, colIndex + 1, visited, word, strIndex + 1)
                    || existCore(board, rowIndex - 1, colIndex, visited, word, strIndex + 1)
                    || existCore(board, rowIndex, colIndex - 1, visited, word, strIndex + 1);

            if (result) {
                return true;
            } else {
                visited[rowIndex][colIndex] = false;
                return false;
            }
        }

        return false;
    }
}