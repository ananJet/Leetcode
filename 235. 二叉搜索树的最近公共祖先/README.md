# 235. 二叉搜索树的最近公共祖先

二叉搜索树的LCA问题，递归找最近的公共祖先

1、如果当前结点为null

2、如果当前结点的值等于任意一个目标节点，返回该结点

3、如果当前结点的值大于其中一个小于另外一个，返回该结点

4、如果当前结点小于均小于两个目标节点，去右边找，否则去左边找


```
public class LowestCommonAncestor1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == q.val || root.val == p.val)
            return root;
        if ((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val))
            return root;
        else if (root.val < p.val && root.val < q.val) {
            return this.lowestCommonAncestor(root.right, p, q);
        }else if (root.val > p.val && root.val > q.val) {
            return this.lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }
}
```
