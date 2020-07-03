class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int pFirst = 0;
        int pLast = nums.length - 1;

        while (pFirst < pLast) {

            while (pFirst < pLast && (nums[pFirst] & 1) != 0) {
                pFirst++;
            }
            while (pFirst < pLast && (nums[pLast] & 1) == 0) {
                pLast--;
            }

            if (pFirst < pLast) {
                int temp = nums[pFirst];
                nums[pFirst] = nums[pLast];
                nums[pLast] = temp;
            }
        }

        return nums;
    }
}