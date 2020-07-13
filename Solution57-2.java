class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= (target / 2)) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] array = new int[right - left];
                for (int i = left; i < right; i++) {
                    array[i - left] = i;
                }
                res.add(array);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}

// https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/