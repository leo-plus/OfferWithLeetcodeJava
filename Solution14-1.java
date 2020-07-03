class Solution {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int[] product = new int[n + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = product[j] * product[i - j];
                max = Math.max(max, temp);
                product[i] = max;
            }
        }

        return product[n];

    }
}