import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    二叉搜索树的中序遍历结果即为从小到大排序的结果
    public Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        this.queue = new LinkedList<>();
        this.midOrder(root);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    public void midOrder(TreeNode root) {
        if (root == null)
            return;
        this.midOrder(root.left);
        this.queue.offer(root.val);
        this.midOrder(root.right);
    }
}
