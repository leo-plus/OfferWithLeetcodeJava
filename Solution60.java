class Solution {
    public double[] twoSum(int n) {
        int dp[][] = new int[n + 1][6 * n + 1];// 表示i个骰子掷出s点的次数
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;// 表示一个骰子掷出i点的次数为1
        }
        for (int i = 2; i <= n; i++) {// 表示骰子的个数
            for (int s = i; s <= 6 * i; s++) {// 表示可能会出现的点数之和
                for (int j = 1; j <= 6; j++) {// 表示当前这个骰子可能掷出的点数
                    if (s - j < i - 1) {// 当总数还没有j大时，就不存在这种情况
                        break;
                    }
                    dp[i][s] += dp[i - 1][s - j];// 当前n个骰子出现的点数之和等于前一次出现的点数之和加上这一次出现的点数
                }
            }
        }
        double total = Math.pow((double) 6, (double) n);// 掷出n次点数出现的所有情况
        double[] ans = new double[5 * n + 1];// 因为最大就只会出现5*n+1中点数
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;// 第i小的点数出现的概率
        }
        return ans;
    }

    // https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/dong-tai-gui-hua-zhu-shi-qing-xi-by-zn5201314/
    // https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
}