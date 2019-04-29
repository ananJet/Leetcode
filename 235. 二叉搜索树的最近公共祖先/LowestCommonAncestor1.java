public class LowestCommonAncestor1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == q.val || root.val == p.val)
            return root;
        if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val))
            return root;
        else if (root.val < p.val && root.val < q.val) {
            return this.lowestCommonAncestor(root.right, p, q);
        }else if (root.val > p.val && root.val > q.val) {
            return this.lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }
}
