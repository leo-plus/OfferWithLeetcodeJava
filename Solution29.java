class Solution {
    int printIndex = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int col = matrix[0].length;
        int row = matrix.length;
        int start = 0;
        int[] result = new int[col * row];

        while (col > start * 2 && row > start * 2) {
            printCicle(matrix, col, row, start, result);
            start++;
        }
        return result;
    }

    private void printCicle(int[][] matrix, int col, int row, int start, int[] result) {
        int endX = col - start - 1;
        int endY = row - start - 1;

        // 左-->右
        for (int i = start; i <= endX; i++) {
            result[printIndex++] = matrix[start][i];
        }

        // 上--》下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result[printIndex++] = matrix[i][endX];
            }
        }

        // 右--》左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result[printIndex++] = matrix[endY][i];
            }
        }

        // 下--》上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result[printIndex++] = matrix[i][start];
            }
        }

    }
}