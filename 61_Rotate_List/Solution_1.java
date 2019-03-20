public class Solution_1 {

//    Runtime: 6 ms, faster than 100.00% of Java online submissions for Rotate List.
//    Memory Usage: 38.1 MB, less than 21.25% of Java online submissions for Rotate List.
    public ListNode rotateRight(ListNode head, int k) {

        //这个解法的核心是，找出右移时溢出的那一部分
        //把溢出的这部分接到前面去

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int size = 0;
        while (tail != null) {
            tail = tail.next;
            size++;
        }

        int n = k % size;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //找出标定点
        ListNode p = head;
        for (int i = 0; i < n; i++) {
            if (p.next == null) {
                p = head;
            } else {
                p = p.next;
            }
        }


        if (p == head) {
            return head;
        }

        ListNode cur = head;
        while (p.next != null) {
            cur = cur.next;
            p = p.next;
        }
        //此时cur的后面全是溢出部分
        p.next = head;
        dummyHead.next = cur.next;
        cur.next = null;

        return dummyHead.next;
    }
}
