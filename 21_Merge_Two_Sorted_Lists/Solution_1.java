public class Solution_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

//        Runtime: 6 ms, faster than 99.80% of Java online submissions for Merge Two Sorted Lists.
//        Memory Usage: 44.5 MB, less than 5.08% of Java online submissions for Merge Two Sorted Lists.
        ListNode curL1 = l1;
        ListNode curL2 = l2;

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (curL1 != null || curL2 != null) {
            if (curL1 == null) {
                tail.next = new ListNode(curL2.val);
                curL2 = curL2.next;
                tail = tail.next;
                continue;
            }
            if (curL2 == null) {
                tail.next = new ListNode(curL1.val);
                curL1 = curL1.next;
                tail = tail.next;
                continue;
            }

            if (curL1.val <= curL2.val) {
                tail.next = new ListNode(curL1.val);
                curL1 = curL1.next;
            } else {
                tail.next = new ListNode(curL2.val);
                curL2 = curL2.next;
            }
            tail = tail.next;
        }

        return dummyHead.next;
    }
}
