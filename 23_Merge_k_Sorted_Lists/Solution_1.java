public class Solution_1 {
//    Runtime: 125 ms, faster than 16.26% of Java online submissions for Merge k Sorted Lists.
//    Memory Usage: 51.4 MB, less than 5.05% of Java online submissions for Merge k Sorted Lists.
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (cur != null) {
            ListNode minNode = findMin(lists);
            cur.next = minNode;

            cur = cur.next;
        }

        return dummyHead.next;
    }

    private ListNode findMin(ListNode[] lists) {
        ListNode minNode = new ListNode(Integer.MAX_VALUE);
        int index = -1;
        for (int i = 0; i < lists.length; ++i) {

            if (lists[i] != null && lists[i].val < minNode.val) {
                minNode = lists[i];
                index = i;
            }
        }

        if (index == -1) {
            return null;
        }
        lists[index] = lists[index].next;
        return minNode;
    }
}
