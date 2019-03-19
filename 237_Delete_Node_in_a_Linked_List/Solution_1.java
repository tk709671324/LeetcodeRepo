public class Solution_1 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
//    Memory Usage: 37.9 MB, less than 18.88% of Java online submissions for Delete Node in a Linked List.
    public void deleteNode(ListNode node) {
        ListNode cur = node;


        while (cur.next.next != null) {
            cur.val = cur.next.val;
            cur = cur.next;
        }

        cur.val = cur.next.val;
        cur.next = null;

    }
}
