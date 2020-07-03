class Solution {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }

    // https://github.com/ryderchan/point-to-offer-edition2/blob/master/src/chapter3/P114_Print1ToMaxOfNDigits.java
}