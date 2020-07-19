import java.util.Arrays;

class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return nums[4] - nums[joker] < 5;

    }
}

// 作者：jyd 链接：https://
// leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/