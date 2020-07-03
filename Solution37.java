/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    int start = 0;// 注意这里必须是全局变量，否则后面的迭代过程中start无法正确变化

    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder res = new StringBuilder();
        recur(root, res);
        return res.toString();
    }

    public void recur(TreeNode root, StringBuilder res) {// 前序遍历
        if (root == null) {
            res.append("null,");// 可以append string
            return;
        }
        res.append(root.val);// append int 由于int位数不定，且可正可负，因此各元素间必须用,分割
        res.append(',');// append char
        recur(root.left, res);
        recur(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;// Sting值相等的判别不能用==
        String inputs[] = data.split(",");
        // 虽然data中以,结尾，但是上述分割后会默认最后一个,不存在 不会使最后一个分割元素为空
        return build(inputs);
    }

    public TreeNode build(String[] inputs) {
        TreeNode res;
        if (inputs[start].equals("null")) {
            start++;
            return null;// 这里说明当前节点为null，自然不存在左右节点了，直接返回
        }
        res = new TreeNode(Integer.parseInt(inputs[start]));
        start++;
        // 注意：start不能以形参的形式引入build方法中，build(inputs,start);如果是这样
        // 下面res.left = build(inputs,start); res.right =
        // build(inputs,start+1);由于处于同一级迭代中start值连续
        // 但实际上res.right中应该是上面res.left迭代完成后才会执行的，start不连续，因此把start作为全局变量较为合适
        res.left = build(inputs);
        res.right = build(inputs);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));