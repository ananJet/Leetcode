import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int val = 0;

    public void rightOrder(TreeNode root) {
        if (root == null)
            return;
        this.rightOrder(root.right);
        root.val += this.val;
        this.val = root.val;
        this.rightOrder(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        this.rightOrder(root);
        return root;
    }

}
