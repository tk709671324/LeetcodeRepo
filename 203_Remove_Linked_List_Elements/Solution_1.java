public class Solution_1 {
    public ListNode removeElements(ListNode head, int val) {
//        Runtime: 3 ms, faster than 100.00% of Java online submissions for Remove Linked List Elements.
//        Memory Usage: 41 MB, less than 24.27% of Java online submissions for Remove Linked List Elements.
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }
        }

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }
}
