class Solution {
    public boolean findNumberIn2DArray(int[][] data, int target) {
        if (data == null || data.length == 0) {
            return false;
        }

        int colMax = data.length - 1;
        int rowMax = data[0].length - 1;
        int col = 0;
        int row = rowMax;
        while (true) {
            if (col < 0 || col > colMax || row > rowMax || row < 0) {
                return false;
            }

            if (data[col][row] == target) {
                return true;
            }

            if (data[col][row] > target) {
                row--;
            } else {
                col++;
            }

        }
    }
}