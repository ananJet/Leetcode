public class SortedArrayToBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] nums;
    public TreeNode root;

//    µÝ¹éº¯Êý
    public TreeNode dg(int left, int right) {
        if (left > right)
            return null;
        int mid = -1;
        if (left == right)
            mid = left;
        mid = (int) Math.ceil((right - left) / 2) + left;
        TreeNode root = new TreeNode(this.nums[mid]);
        root.left = this.dg(left, mid - 1);
        root.right = this.dg(mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        this.root = this.dg(0, nums.length - 1);
        return this.root;
    }
}
