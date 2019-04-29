# 236. 二叉树的最近公共祖先

LCA问题，递归

1、如果当前结点为空，返回空

2、如果当前结点等于任意一个目标节点，返回当前结点

3、分别去左边找和去右边找，如果左右两边都不为空，返回当前结点，如果左边不为空，右边为空，返回左边找到的结点，如果右边不为空，左边为空，返回右边找到的结点


```
public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = this.lowestCommonAncestor(root.left, p, q);
        TreeNode right = this.lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        return null;
    }
}

```
