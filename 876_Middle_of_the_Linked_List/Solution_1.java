public class Solution_1 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
//    Memory Usage: 36.7 MB, less than 60.86% of Java online submissions for Middle of the Linked List.
    public ListNode middleNode(ListNode head) {

        ListNode middle = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        return middle;
    }
}
