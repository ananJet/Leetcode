import java.util.ArrayList;

public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        if (len <= 2)
            return;
        int n = len / 2;
//        选择分割点
        ListNode cut = head;
        while (n > 0) {
            cut = cut.next;
            n--;
        }
        temp = cut;
        cut = cut.next;
        temp.next = null;
//        反转链表
        if (cut.next != null) {
            ListNode now = cut.next;
            cut.next = null;
            while (now != null) {
                ListNode tempNode = now.next;
                now.next = cut;
                cut = now;
                now = tempNode;
            }
        }
        this.printList(head);
        this.printList(cut);
//        间隔插入
        ListNode temp1 = head;
        ListNode temp2 = cut;
        while (temp2 != null) {
            ListNode tempNode = temp1.next;
            ListNode tempNode1 = temp2.next;
            temp1.next = temp2;
            temp2.next = tempNode;
            temp1 = tempNode;
            temp2 = tempNode1;
        }
    }

}
