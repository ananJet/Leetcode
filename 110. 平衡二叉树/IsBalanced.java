public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getH(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = 1 + this.getH(root.left);
        int right = 1 + this.getH(root.right);
        return Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int left = this.getH(root.left);
        int right = this.getH(root.right);
        return Math.abs(left - right) <= 1 && this.isBalanced(root.left) && this.isBalanced(root.right);
    }
}
