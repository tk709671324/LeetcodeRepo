public class Solution_2 {

//    Runtime: 5 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
//    Memory Usage: 37.9 MB, less than 41.35% of Java online submissions for Remove Nth Node From End of List.
    //双指针方法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }

        while (tail != null) {
            tail = tail.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummyHead.next;
    }
}
