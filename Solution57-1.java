class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left]+nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                int[] result = new int[2];
                result[0] = nums[left];
                result[1] = nums[right];
                return result;
            }
        }

        return new int[0];
    }
}