public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int l = 1;
        while (temp.next != null){
            temp = temp.next;
            l++;
        }
//        l是链表长度，n是倒数第几位
        int time = l - n;
        ListNode target = head;
        ListNode last = null;
//        target目标节点，last是目标节点的上一个节点
        for (int i = 0; i < time; i++){
            last = target;
            target = target.next;
        }
        if (target.next != null){
            target.val = target.next.val;
            target.next = target.next.next;
            return head;
        }else if (last == null){
            return null;
        }else {
            last.next = null;
            return head;
        }
    }
}
