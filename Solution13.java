class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int count = movingCountCore(k, m, n, 0, 0, visited);

        return count;
    }

    private int movingCountCore(int k, int rowLen, int colLen, int row, int col, boolean[][] visited) {
        int count = 0;

        if (check(k, rowLen, colLen, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(k, rowLen, colLen, row + 1, col, visited)
                    + movingCountCore(k, rowLen, colLen, row - 1, col, visited)
                    + movingCountCore(k, rowLen, colLen, row, col + 1, visited)
                    + movingCountCore(k, rowLen, colLen, row, col - 1, visited);
        }

        return count;
    }

    private boolean check(int k, int rowLen, int colLen, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rowLen && col >= 0 && col < colLen && !visited[row][col]
                && getDigitSum(row) + getDigitSum(col) <= k) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

}