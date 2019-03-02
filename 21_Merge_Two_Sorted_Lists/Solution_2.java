public class Solution_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        Runtime: 6 ms, faster than 99.80% of Java online submissions for Merge Two Sorted Lists.
//        Memory Usage: 42.8 MB, less than 5.08% of Java online submissions for Merge Two Sorted Lists.
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
