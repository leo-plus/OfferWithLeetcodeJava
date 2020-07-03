class Solution {
    public boolean verifyPostorder(int[] data) {
        // 空树
        if (data == null || data.length == 0)
            return true;
        return verifySquenceOfBST(data, 0, data.length - 1);
    }

    public boolean verifySquenceOfBST(int[] data, int start, int end) {
        // 数组长度为2，一定能够组成BST
        if (end - start <= 1)
            return true;
        int root = data[end];
        int rightStart = 0;
        for (; rightStart < end; rightStart++) {
            if (data[rightStart] > root) {
                break;
            }
        }

        for (int i = rightStart; i < end; i++) {
            if (data[i] < root)
                return false;
        }
        return verifySquenceOfBST(data, start, rightStart - 1) && verifySquenceOfBST(data, rightStart, end - 1);
    }
}