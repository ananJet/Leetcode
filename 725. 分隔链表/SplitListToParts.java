public class SplitListToParts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null)
            return new ListNode[k];
//        得到链表长度
        ListNode temp = root;
        int len = 0;
        while (!(temp == null)) {
            temp = temp.next;
            len++;
        }

        ListNode[] res = new ListNode[k];
        if (len <= k) {
            temp = root;
            int k_index = 0;
            while (!(temp == null)) {
                res[k_index] = new ListNode(temp.val);
                temp = temp.next;
                k_index++;
            }
        }else {
            int a = len % k;
            int b = len / k;
//        如果能整除，说明能整分
            if (a == 0) {
                int pack = b;
                temp = root;
                int k_index = 0;
                while (k_index < k) {
                    int pack_index = 1;
                    ListNode newHead = new ListNode(temp.val);
                    ListNode newTemp = newHead;
                    while (pack_index < pack) {
                        temp = temp.next;
                        newTemp.next = new ListNode(temp.val);
                        newTemp = newTemp.next;
                        pack_index++;
                    }
                    temp = temp.next;
                    res[k_index] = newHead;
                    k_index++;
                }
            }else {
//                前一段的pack1
                int pack1 = b + 1;
                int pack1_len = k - (pack1 * k - len);
//                后一段的pack2
                int pack2 = b;
                int pack2_len = k - pack1_len;

//                pack1
                temp = root;
                int k1_index = 0;
                while (k1_index < pack1_len) {
                    int pack_index = 1;
                    ListNode newHead = new ListNode(temp.val);
                    ListNode newTemp = newHead;
                    while (pack_index < pack1) {
                        temp = temp.next;
                        newTemp.next = new ListNode(temp.val);
                        newTemp = newTemp.next;
                        pack_index++;
                    }
                    temp = temp.next;
                    res[k1_index] = newHead;
                    k1_index++;
                }

//                pack2
                int k2_index = 0;
                while (k2_index < pack2_len) {
                    int pack_index = 1;
                    ListNode newHead = new ListNode(temp.val);
                    ListNode newTemp = newHead;
                    while (pack_index < pack2) {
                        temp = temp.next;
                        newTemp.next = new ListNode(temp.val);
                        newTemp = newTemp.next;
                        pack_index++;
                    }
                    temp = temp.next;
                    res[k2_index + pack1_len] = newHead;
                    k2_index++;
                }
            }
        }
        return res;
    }
}
