public class Solution_1 {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {

//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode pre = null;
//        ListNode curr = head; //需要翻转的节点
//
//        while (curr != null) {
//            ListNode next = curr.next;
//
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//
//        return pre;


//        Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
//        Memory Usage: 37.9 MB, less than 13.35% of Java online submissions for Reverse Linked List.

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head; //需要翻转的节点
        ListNode next = curr.next;

        while (next != null) {
            curr.next = pre; //翻转当前节点

            //往后移动
            pre = curr;
            curr = next;
            next = curr.next;
        }

        curr.next = pre;
        return curr;
    }

}
