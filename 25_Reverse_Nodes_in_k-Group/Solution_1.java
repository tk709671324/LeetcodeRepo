

public class Solution_1 {

//    Runtime: 3 ms, faster than 99.36% of Java online submissions for Reverse Nodes in k-Group.
//    Memory Usage: 39.3 MB, less than 30.55% of Java online submissions for Reverse Nodes in k-Group.

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode start = dummyHead;
        ListNode end = start;

        while (true) {
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return dummyHead.next;
                } else {
                    end = end.next;
                }
            }
            ListNode nextStart = start.next;
            reverseNode(start, k, end.next);
            start = nextStart;
            end = start;
        }
    }

    private ListNode reverseNode(ListNode prehead, int k, ListNode tail) {
        //将prehead后面k个翻转后接上prehead
        //tail为待翻转k个元素后面的一个元素
        ListNode pre = tail;
        ListNode cur = prehead.next;
        ListNode next = cur.next;
        for (int i = 0; i < k; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = (cur == null) ? null : cur.next;
        }

        prehead.next = pre;
        return prehead;
    }
}
