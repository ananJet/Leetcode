# 543. 二叉树的直径

对二叉树中的每个结点计算左子树和右子树的和，取最大值


```
import java.util.Stack;

public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
//        层次遍历
        int r = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
//        获得左结点和右结点子树的深度
            r = Math.max(r, this.dg(node.left) + this.dg(node.right));
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return r;
    }

    public int dg(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(this.dg(root.left) + 1, this.dg(root.right) + 1);

    }


}

```
