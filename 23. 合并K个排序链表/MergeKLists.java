import java.util.Arrays;
import java.util.List;

public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (!(temp == null)) {
                temp = temp.next;
                n++;
            }
        }
        if (n == 0)
            return null;
        int[] r = new int[n];
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (!(temp == null)) {
                r[index] = temp.val;
                temp = temp.next;
                index++;
            }
        }
        Arrays.sort(r);

        ListNode head = new ListNode(r[0]);
        ListNode temp = head;
        for (int i = 1; i < r.length; i++) {
            temp.next = new ListNode(r[i]);
            temp = temp.next;
        }
        return head;
    }
}
