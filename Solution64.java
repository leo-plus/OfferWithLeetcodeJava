class Solution {
    public int sumNums(int n) {
        if (n == 1)
            return 1;
        n += sumNums(n - 1);
        return n;
    }

    // 作者：jyd
    // 链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
    // 来源：力扣（LeetCode）著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
