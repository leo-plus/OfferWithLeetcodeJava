class Solution {
    public boolean isBalanced(TreeNode root) {
        return core(root) != -1;
    }

    private int core(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = core(root.left);
        if (left == -1) {
            return -1;
        }

        int right = core(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}

// https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/