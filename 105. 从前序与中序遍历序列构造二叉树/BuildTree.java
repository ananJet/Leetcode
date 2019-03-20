public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] preorder;
    public int[] inorder;

    public TreeNode dg(int left_pre, int right_pre, int left_in, int right_in) {
        if (left_pre > right_pre)
            return null;
        if (left_pre == right_pre)
            return new TreeNode(this.preorder[left_pre]);
        //根据前序部分找根结点
        TreeNode root = new TreeNode(this.preorder[left_pre]);
        int index = -1;
        for (int i = left_in; i <= right_in; i++) {
            if (this.inorder[i] == this.preorder[left_pre])
                index = i;
        }
//        左子树
        root.left = this.dg(left_pre + 1, left_pre + index - left_in, left_in, index - 1);
//        右子树
        root.right = this.dg(left_pre + 1 + index - left_in, right_pre,  index + 1, right_in);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return this.dg(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        new BuildTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
