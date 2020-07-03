class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int one = 1;
        int two = 0;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = (one + two) % 1000000007;

            two = one;
            one = sum;

        }

        return sum;
    }
}