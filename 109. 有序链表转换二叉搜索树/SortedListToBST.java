public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        int len = 0;
        ListNode temp = head;
        while (!(temp == null)) {
            len++;
            temp = temp.next;
        }

//        得到有序链表转换成的数组
        int[] r = new int[len];
        int index = 0;
        temp = head;
        while (!(temp == null)) {
            r[index] = temp.val;
            index++;
            temp = temp.next;
        }

        return this.buildBST(0, r.length - 1, r);
    }

    public TreeNode buildBST(int left, int right, int[] r) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(r[left]);
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(r[mid]);
        root.left = this.buildBST(left, mid - 1, r);
        root.right = this.buildBST(mid + 1, right, r);
        return root;
    }
}
