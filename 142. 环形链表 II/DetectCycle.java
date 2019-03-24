public class DetectCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
//        判断链表是否有环，快慢指针相遇法
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while (true) {
            if (fast == null)
                return null;
            if (slow.next == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }

//        找到有环，找环的入口，双指针分别从头结点和相遇点出发
        if (head == meet)
            return head;
        ListNode find = head;
        while (true) {
            find = find.next;
            meet = meet.next;
            if (find == meet) {
                return find;
            }
        }
    }
}
