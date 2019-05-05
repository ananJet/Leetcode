import java.util.Stack;

public class GetMinimumDifference {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int min;

    public int getMinimumDifference(TreeNode root) {
//        ����ÿ�����еĽ�㣬�ҵ�ǰ��������С�������Ĳ��Լ�����������С���Ĳ�
        this.min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                stack.push(temp.left);
                int l = temp.val - this.getLeft(temp.left);
                if (l < this.min)
                    this.min = l;
            }
            if (temp.right != null) {
                stack.push(temp.right);
                int r = this.getRight(temp.right) - temp.val;
                if (r < this.min)
                    this.min = r;
            }

        }
        return this.min;
    }

    public int getLeft(TreeNode root) {
        if (root.right == null)
            return root.val;
        return this.getLeft(root.right);
    }

    public int getRight(TreeNode root) {
        if (root.left == null)
            return root.val;
        return this.getRight(root.left);
    }
}
