public class Flatten {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void dg(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        this.dg(root.left);
        this.dg(root.right);
        if (root.right != null) {
            TreeNode temp = root;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = root.right;
            root.right = null;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        this.dg(root);
        TreeNode temp = root;
        while (temp.left != null) {
            temp.right = temp.left;
            temp.left = null;
            temp = temp.right;
        }
    }
}
