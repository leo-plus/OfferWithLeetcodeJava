class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchCore(s, 0, p, 0);
    }

    private boolean isMatchCore(String s, int sIndex, String p, int pIndex) {
        // 字符串和模式都结束了
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }

        // 字符串没结束，模式结束了
        if (sIndex != s.length() && pIndex == p.length()) {
            return false;
        }

        // 字符串结束了，模式没结束
        if (sIndex == s.length() && pIndex != p.length()) {
            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                return isMatchCore(s, sIndex, p, pIndex + 2);
            } else {
                return false;
            }
        }
        // 如果 已经只剩一个字符了 || 模式串的第二个字符不是*
        if (pIndex == p.length() - 1 || p.charAt(pIndex + 1) != '*') {
            if (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex)) {
                return isMatchCore(s, sIndex + 1, p, pIndex + 1);
            } else {
                return false;
            }
        } else {
            // 如果模式串的第二个字符是*
            if (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex)) {

                return isMatchCore(s, sIndex, p, pIndex + 2) || isMatchCore(s, sIndex + 1, p, pIndex)
                        || isMatchCore(s, sIndex + 1, p, pIndex + 2);
            } else {
                return isMatchCore(s, sIndex, p, pIndex + 2);
            }

        }

    }
}