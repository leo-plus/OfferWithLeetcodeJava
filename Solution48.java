import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int preD = 0;
        int res = 0;
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            int d;
            if (preD < (j - i)) {
                d = preD + 1;
            } else {
                d = j - i;
            }

            res = Math.max(res, d);
            preD = d;

        }

        return res;
    }
}

// https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
// 最好结合书里的例子看，上面这个题解太抽象