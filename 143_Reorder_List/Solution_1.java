public class Solution_1 {

//    Runtime: 2 ms, faster than 94.73% of Java online submissions for Reorder List.
//    Memory Usage: 40.7 MB, less than 9.72% of Java online submissions for Reorder List.
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        //总结，关于链表双指针取中间元素的模版

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        boolean isOdd = false;
        if (fast != null) {
            //按照这个写法，如果fast非空，即指向最后一个节点则是链表长度为奇数，slow下一个才是中间节点。
            slow = slow.next;
            isOdd = true;
        }


        ListNode cur = slow.next;
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        ListNode front = head;
        int size = list.size();
        while (size != 0) {
            ListNode insert = list.remove(size - 1);
            size--;
            ListNode next = front.next;
            front.next = insert;
            insert.next = next;
            front = next;
        }

        if (isOdd) {
            front.next = null;
        } else {
            front.next.next = null;
        }
    }
}
