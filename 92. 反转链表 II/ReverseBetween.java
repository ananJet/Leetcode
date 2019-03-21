import java.util.ArrayList;

public class ReverseBetween {

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


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode temp = head;
        int len = 0;
        ListNode part_head = null;
        ListNode part_tail = null;
//        截断点的上一个结点
        ListNode in = null;
//        截断点的下一个结点
        ListNode out = null;
        while (temp != null) {
            len += 1;
//            System.out.println(len);
            if (len < m) {
                if (len == m - 1) {
                    in = temp;
                }
            }else if (len <= n) {
//                System.out.println(temp.val);
                ListNode target = new ListNode(temp.val);
                if (len == m)
                    part_tail = target;
                target.next = part_head;
                part_head = target;
            }else {
                if (len == n + 1)
                    out = temp;
            }
            temp = temp.next;
        }
//        this.printList(part_head);
        if (in == null) {
            head = part_head;
        }else {
            in.next = part_head;
        }
        part_tail.next = out;
        return head;
    }

    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = reverseBetween.createList(new int[]{1, 2, 3, 4, 5});
        ListNode result = reverseBetween.reverseBetween(head, 2, 4);
        reverseBetween.printList(result);
    }
}
