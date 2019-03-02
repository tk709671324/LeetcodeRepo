public class Solution_2 {
    public ListNode deleteDuplicates(ListNode head) {
//
//        Runtime: 1 ms, faster than 63.71% of Java online submissions for Remove Duplicates from Sorted List II.
//        Memory Usage: 37.5 MB, less than 62.94% of Java online submissions for Remove Duplicates from Sorted List II.

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.next != null && cur.next.val == cur.next.next.val) {
                int delVal = cur.next.val;
                while (cur.next != null && cur.next.val == delVal) {
                    ListNode delNode = cur.next;
                    cur.next = delNode.next;
                    delNode.next = null;
                }
            } else {
                cur = cur.next;
            }
        }

        ListNode retHead = dummyHead.next;
        dummyHead.next = null;
        return retHead;
    }
}
