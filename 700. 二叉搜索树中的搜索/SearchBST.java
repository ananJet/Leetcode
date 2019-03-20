public class SearchBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == val)
                return temp;
            else if (root.val < val)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return temp;
    }
}
