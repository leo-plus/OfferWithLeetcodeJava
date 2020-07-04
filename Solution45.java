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
            while (true) {
                String a = strs[j] + strs[l];
                String b = strs[l] + strs[j];
                if (a.compareTo(b) >= 0 && i < j) {
                    j--;
                } else {
                    break;
                }
            }

            while (true) {
                String a = strs[i] + strs[l];
                String b = strs[l] + strs[i];
                if (a.compareTo(b) <= 0 && i < j) {
                    i++;
                } else {
                    break;
                }
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

// https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/