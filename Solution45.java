class Solution {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = nums[i] + "";
        }

        fastSort(strs, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();

    }

    private void fastSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        String tmp = strs[i];
        while (i < j) {
            while (i < j && (strs[l] + strs[i]).compareTo((strs[i] + strs[l])) <= 0) {
                i++;
            }

            while (i < j && (strs[l] + strs[j]).compareTo((strs[j] + strs[l])) >= 0) {
                j--;
            }

            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }

        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }
}