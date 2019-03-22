import java.util.LinkedList;
import java.util.Queue;

public class IsSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (!(s != null && t != null))
            return false;
        else {
            if (s.val == t.val) {
                return this.isSame(s.left, t.left) && this.isSame(s.right, t.right);
            }else
                return false;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (this.isSame(temp, t))
                return true;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return false;
    }
}
