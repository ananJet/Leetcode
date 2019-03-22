public class FindTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getSum(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        return root.val + this.getSum(root.left) + this.getSum(root.right);
    }

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return Math.abs(this.getSum(root.left) - this.getSum(root.right)) + this.findTilt(root.left) + this.findTilt(root.right);
    }

    public int res = 0;

    public int findTilt1(TreeNode root) {
        this.travel(root);
        return this.res;
    }

    public int travel(TreeNode root) {
        if (root == null)
            return 0;
        int left = this.travel(root.left);
        int right = this.travel(root.right);
        this.res += Math.abs(right - left);
        return left + right + root.val;
    }
}
