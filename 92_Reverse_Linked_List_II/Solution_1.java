public class Solution_1 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        //移动到m的位置
        for (int i = 1; i < m + 1; i++) {
            pre = curr;
            curr = curr.next;
        }

        for (int i = m ; i < n + 1; i++) {
            ListNode next = curr.next;
            //开始反转
            curr.next = pre;
            //移动
            pre = curr;
            curr = next;
            if (curr != null) {
                next = curr.next;
            }
        }

        return head;
    }
}
