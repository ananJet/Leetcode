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
//        l�������ȣ�n�ǵ����ڼ�λ
        int time = l - n;
        ListNode target = head;
        ListNode last = null;
//        targetĿ��ڵ㣬last��Ŀ��ڵ����һ���ڵ�
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
