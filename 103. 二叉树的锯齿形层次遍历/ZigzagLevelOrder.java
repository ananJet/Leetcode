import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        stack.add(root);
        while (true) {
            if (stack.isEmpty())
                break;
            List<Integer> r = new LinkedList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                r.add(temp.val);
                if ((index & 1) == 0) {
                    if (temp.left != null)
                        stack1.push(temp.left);
                    if (temp.right != null)
                        stack1.push(temp.right);
                }else {
                    if (temp.right != null)
                        stack1.push(temp.right);
                    if (temp.left != null)
                        stack1.push(temp.left);
                }
            }
            stack = stack1;
            res.add(r);
            index++;
        }
        return res;
    }
}
