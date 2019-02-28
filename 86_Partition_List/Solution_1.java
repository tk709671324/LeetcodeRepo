public class Solution_1 {


//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
//    Memory Usage: 36.9 MB, less than 20.60% of Java online submissions for Partition List.

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode lessHead = null, lessTail = null;
        ListNode biggerHead = null, biggerTail = null;

        while (cur != null) {
            if (cur.val < x) {
                if (lessHead == null) {
                    lessHead = new ListNode(cur.val);
                    lessTail = lessHead;
                } else {
                    lessTail.next = new ListNode(cur.val);
                    lessTail = lessTail.next;
                }
            } else {
                if (biggerHead == null) {
                    biggerHead = new ListNode(cur.val);
                    biggerTail = biggerHead;
                } else {
                    biggerTail.next = new ListNode(cur.val);
                    biggerTail = biggerTail.next;
                }
            }

            cur = cur.next;
        }

        if (lessHead != null) {
            lessTail.next = biggerHead;
        } else {
            lessHead = biggerHead;
        }

        return lessHead;
    }
}
