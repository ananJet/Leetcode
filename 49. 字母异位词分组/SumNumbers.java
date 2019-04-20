public class SumNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int res;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        this.res = 0;
        StringBuilder s = new StringBuilder();
        s.append(root.val);
        this.dg(s, root);
        return this.res;
    }

    public void dg(StringBuilder s, TreeNode root) {
        if (root.left == null && root.right == null) {
            this.res += Integer.parseInt(s.toString());
            return;
        }else {
            if (root.left != null) {
                s.append(root.left.val);
                this.dg(s, root.left);
                s.deleteCharAt(s.length() - 1);
            }
            if (root.right != null) {
                s.append(root.right.val);
                this.dg(s, root.right);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}
