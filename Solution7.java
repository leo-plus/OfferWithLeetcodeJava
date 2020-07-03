/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return coreConstruct(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode coreConstruct(int[] preorder, int preorder_start, int[] inorder, int inorder_start, int length) {
        if (length == 0) {
            return null;
        }

        int inorder_index = -1;
        for (int i = inorder_start; i < inorder_start + length; i++) {
            if (inorder[i] == preorder[preorder_start]) {
                inorder_index = i;
                break;
            }
        }

        int left_length = inorder_index - inorder_start;
        TreeNode node = new TreeNode(preorder[preorder_start]);
        node.left = coreConstruct(preorder, preorder_start + 1, inorder, inorder_start, left_length);
        node.right = coreConstruct(preorder, preorder_start + 1 + left_length, inorder, inorder_index + 1,
                length - left_length - 1);
        return node;
    }
}