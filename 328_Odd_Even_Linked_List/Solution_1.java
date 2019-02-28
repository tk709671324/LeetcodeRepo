public class Solution_1 {
    public ListNode oddEvenList(ListNode head) {


//        Runtime: 2 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
//        Memory Usage: 37 MB, less than 89.67% of Java online submissions for Odd Even Linked List.

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddLast = head;
        ListNode evenLast = head.next;
        ListNode evenHead = head.next;

        //有两种情况结束， 以奇数结束和以偶数结束
        //以奇数结束的时候，更新后evenlast为空
        //以偶数结束的时候evenLast更新后next为空
        while (evenLast != null && evenLast.next != null) {
            oddLast.next = evenLast.next;
            oddLast = oddLast.next;
            evenLast.next = oddLast.next;
            evenLast = evenLast.next;
        }

        oddLast.next = evenHead;
        return head;

    }
}
