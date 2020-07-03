class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;
            } else if (str[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (eSeen || !numSeen) {
                    return false;
                }

                eSeen = true;
                numSeen = false;// 重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }
}

// 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/javaban-ben-ti-jie-luo-ji-qing-xi-by-yangshyu6/