/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (B == null) {
            return false;
        }

        if (A == null) {
            return false;
        }

        if (A.val == B.val) {
            if (doesTreeHasTree2(A, B)) {
                return true;
            }
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    private boolean doesTreeHasTree2(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return doesTreeHasTree2(A.left, B.left) && doesTreeHasTree2(A.right, B.right);
    }
}