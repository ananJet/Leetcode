import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node = new GenerateTrees().copy(node);
        System.out.println(node.val + "\t" + node.left.val + "\t" + node.right.val);
    }

    public TreeNode copy(TreeNode root) {
        if (root == null)
            return null;
        TreeNode nodeLeft = this.copy(root.left);
        TreeNode nodeRight = this.copy(root.right);
        TreeNode nodeRoot = new TreeNode(root.val);
        nodeRoot.left = nodeLeft;
        nodeRoot.right = nodeRight;
        return nodeRoot;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 0)
            return res;
        res.add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            List<TreeNode> temp = new LinkedList<>();
            TreeNode nowNode = new TreeNode(i);
            for (TreeNode node : res) {
                TreeNode headNode = node;
                TreeNode tempNode = node;
//                树的开头作为插入点
                nowNode.left = node;
                TreeNode copyNode = this.copy(nowNode);
                temp.add(copyNode);
                nowNode.left = null;

//                从树的中间搜索插入点
                while (tempNode.right != null) {
//                    插入
                    TreeNode t = tempNode.right;
                    tempNode.right = nowNode;
                    nowNode.left = t;

//                    复制
                    copyNode = this.copy(headNode);
                    temp.add(copyNode);

//                    复原
                    tempNode.right = tempNode.right.left;
                    nowNode.left = null;

//                    搜索下一个插入点
                    tempNode = tempNode.right;
                }

//                树的末端作为插入点
                tempNode.right = nowNode;
                copyNode = this.copy(headNode);
                temp.add(copyNode);
                tempNode.right = null;
            }
            res = temp;
        }
        return res;
    }

}
