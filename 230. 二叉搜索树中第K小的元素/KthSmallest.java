import java.util.LinkedList;
import java.util.Queue;

public class KthSmallest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public Queue<Integer> queue;

    public int kthSmallest(TreeNode root, int k) {
//        中序遍历二叉搜索树得到从小到大的队列
        this.queue = new LinkedList<>();
        this.midOrder(root);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = this.queue.poll();
        }
        return res;
    }

    public void midOrder(TreeNode root) {
        if (root == null)
            return;
        this.midOrder(root.left);
        this.queue.offer(root.val);
        this.midOrder(root.right);
    }
}
