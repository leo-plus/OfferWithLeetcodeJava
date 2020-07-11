class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }

        int first = sum & -sum;
        int a = 0;
        int b = 0;

        for (int i : nums) {
            if ((i & first) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }

        int[] result = new int[2];
        result[0] = a;
        result[1] = b;

        return result;

    }
}