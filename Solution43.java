class Solution {
    public int countDigitOne(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        } else {
            return pow + high * f(pow - 1) + f(last);
        }
    }
}

// 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/javadi-gui-by-xujunyi/