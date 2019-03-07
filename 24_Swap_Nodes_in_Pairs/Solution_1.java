public class Solution_1 {

//    Runtime: 2 ms, faster than 99.95% of Java online submissions for Swap Nodes in Pairs.
//    Memory Usage: 37 MB, less than 16.63% of Java online submissions for Swap Nodes in Pairs.
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            pre.next = node2;

            pre = node1; //node1已经是较靠后的那一个了
        }

        return dummyHead.next;
    }
}
