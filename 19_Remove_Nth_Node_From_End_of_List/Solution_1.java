public class Solution_1 {


//    Runtime: 6 ms, faster than 74.28% of Java online submissions for Remove Nth Node From End of List.
//    Memory Usage: 38 MB, less than 34.20% of Java online submissions for Remove Nth Node From End of List.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        list.add(dummyHead);
        int size = 1;

        ListNode cur = head;

        while (cur != null) {
            list.add(cur);
            cur = cur.next;
            size++;
        }

        int index = size - n;
        ListNode pre = list.get(index - 1);
        ListNode del = list.get(index);
        if (del.next == null) {
            pre.next = null;
        } else {
            pre.next = del.next;
        }

        return dummyHead.next;
    }
}
