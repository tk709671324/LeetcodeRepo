public class Solution_1 {
//    Runtime: 4 ms, faster than 97.63% of Java online submissions for Insertion Sort List.
//    Memory Usage: 37.6 MB, less than 67.90% of Java online submissions for Insertion Sort List.
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tail = head;
        ListNode cur = head.next;


        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val >= tail.val) {
                tail = cur;
                cur = cur.next;
                continue;
            }

            ListNode sel = dummyHead;
            while (sel != tail) {
                if (sel.next.val >= cur.val) {
                    cur.next = sel.next;
                    sel.next = cur;
                    break;
                } else {
                    sel = sel.next;
                }
            }

            cur = next;
            tail.next = cur;
        }

        return dummyHead.next;
    }
}
