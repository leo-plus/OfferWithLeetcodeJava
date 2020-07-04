class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1; // i-1
        int b = 1; // i-2
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c;
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                c = a + b;
            } else {
                c = a;
            }

            b = a;
            a = c;
        }

        return a;
    }
}

// https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/