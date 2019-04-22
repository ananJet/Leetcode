import java.util.LinkedList;
import java.util.List;

public class RightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> res;
    private int height;

    public List<Integer> rightSideView(TreeNode root) {
        this.res = new LinkedList<>();
        if (root == null)
            return this.res;
        this.height = 0;
        this.dg(root, 0);
        return this.res;
    }

    public void dg(TreeNode root, int now_height) {
        if (root == null)
            return;
        if (now_height == this.height) {
            this.res.add(root.val);
            this.height++;
        }
        this.dg(root.right, now_height + 1);
        this.dg(root.left, now_height + 1);
    }
}
