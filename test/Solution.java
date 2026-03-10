class Solution {


    public ListNode sortList(ListNode head) {
        return quickSort(head);
    }

    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) return head;
        // 把 < head.val 的所有元素存到链表 smallDummy 中，把 >= head.val 的所有元素存到链表 largeDummy 中
        ListNode smallDummy = new ListNode(), p1 = smallDummy;
        ListNode largeDummy = new ListNode(), p2 = largeDummy;
        ListNode p = head.next;
        while (p != null) {
            ListNode nxt = p.next;
            p.next = null;
            if (p.val < head.val) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = nxt;
        }

        p1.next = null;
        head.next = null;
        p2.next = null;    // 必须加，不然会导致链表成环，死循环

        ListNode smallHead = quickSort(smallDummy.next);
        ListNode largeHead = quickSort(largeDummy.next);

        p1.next = head;
        head.next = largeHead;

        return smallHead;
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }

    // p q
    // 0 1 copyRandomList
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode h = new Solution().removeNthFromEnd(node1, 2);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
//        System.out.println(h);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

