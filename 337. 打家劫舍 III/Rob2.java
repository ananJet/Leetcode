public class Rob2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
//        取根结点的结果
        int temp1 = 0;
        if (!(root.left != null && root.right != null)) {
            TreeNode notnull_node = root.left == null ? root.right : root.left;
            temp1 = root.val + this.rob(notnull_node.left) + this.rob(notnull_node.right);
        }else {
            temp1 = root.val + this.rob(root.left.left) + this.rob(root.left.right) + this.rob(root.right.left) + this.rob(root.right.right);
        }
//        不取根结点的结果
        int temp2 = this.rob(root.left) + this.rob(root.right);
        return Math.max(temp1, temp2);
    }
}
