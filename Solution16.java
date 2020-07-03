class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }
        int abs = n;
        if (n < 0) {
            abs = -n;
        }

        double result = pow(x, n);
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }

    }

    private double pow(double x, int n) {

        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double result = pow(x, n / 2);
        result = result * result;
        if (n % 2 != 0) {
            result = result * x;
        }

        return result;
    }
}