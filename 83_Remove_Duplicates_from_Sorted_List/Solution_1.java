import java.util.HashSet;

public class Solution_1 {

//    Runtime: 1 ms, faster than 44.31% of Java online submissions for Remove Duplicates from Sorted List.
//    Memory Usage: 37.9 MB, less than 13.55% of Java online submissions for Remove Duplicates from Sorted List.

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            if (!set.add(cur.val)) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
