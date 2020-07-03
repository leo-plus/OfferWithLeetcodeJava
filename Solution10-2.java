class Solution {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }

        int one = 1;
        int two = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = (one + two) % 1000000007;

            two = one;
            one = sum;

        }

        return sum;
    }
}