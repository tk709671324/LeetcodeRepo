import java.util.HashMap;

public class Solution_1 {
    public ListNode deleteDuplicates(ListNode head) {
//        Runtime: 4 ms, faster than 5.81% of Java online submissions for Remove Duplicates from Sorted List II.
//        Memory Usage: 37.1 MB, less than 77.95% of Java online submissions for Remove Duplicates from Sorted List II.

        //审题不仔细。。没看到是有序的

        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                map.put(cur.val, map.get(cur.val) + 1);
            } else {
                map.put(cur.val, 1);
            }

            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        cur = dummyHead;

        while (cur.next != null) {
            if (map.get(cur.next.val) > 1) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else {
                cur = cur.next;
            }
        }

        ListNode retHead = dummyHead.next;
        dummyHead.next = null;
        return retHead;
    }
}
