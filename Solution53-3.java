/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int mK;
    int mRes;
    public int kthLargest(TreeNode root, int k) {
        mK = k;
        dfs(root);
        return mRes;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (mK == 0) {
            return;
        }
        if (--mK == 0) {
            mRes = root.val;
        }
        dfs(root.left);
    }
}

//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/