import java.util.ArrayList;

public class Partition {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode createList(int[] nums) {
        if (nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (temp != null) {
            arrayList.add(temp.val);
            temp = temp.next;
        }
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 3, 2, 5, 2};
        Partition obj = new Partition();
        ListNode head = obj.createList(a);
        obj.printList(head);
        ListNode result = obj.partition1(head, 1);
        obj.printList(result);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small_head = null;
        ListNode big_head = null;
        ListNode small = null;
        ListNode big = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                if (small_head == null) {
                    small_head = temp;
                    small = temp;
                }else {
                    small.next = temp;
                    small = temp;
                }
            }else {
                if (big_head == null) {
                    big_head = temp;
                    big = temp;
                }else {
                    big.next = temp;
                    big = temp;
                }
            }
            temp = temp.next;
        }
        ListNode result = null;
        if (small_head != null && big_head != null) {
            small.next = big_head;
            big.next = null;
            result = small_head;
        }else if (small_head != null && big_head == null) {
            small.next = null;
            result = small_head;
        }else if (small_head == null && big_head != null) {
            big.next = null;
            result = big_head;
        }else {
            result = null;
        }
        return result;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode small_head = new ListNode(-1);
        ListNode big_head = new ListNode(-1);
        ListNode small = small_head;
        ListNode big = big_head;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                small.next = new ListNode(temp.val);
                small = small.next;
            }else {
                big.next = new ListNode(temp.val);
                big = big.next;
            }
            temp = temp.next;
        }
        small.next = big_head.next;
        return small_head.next;
    }

}
