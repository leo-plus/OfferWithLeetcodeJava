class Solution {
    public int findRepeatNumber(int[] nums) {

        if (nums == null || nums.length < 2) {
            return -1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (i != nums[i]) {

                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }

            }
        }

        return -1;
    }
}