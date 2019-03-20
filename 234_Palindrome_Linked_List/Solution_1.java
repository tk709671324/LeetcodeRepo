public class Solution_1 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Palindrome Linked List.
//    Memory Usage: 42.5 MB, less than 33.20% of Java online submissions for Palindrome Linked List.
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;
        ListNode next = slow.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            //翻转
            next = slow.next;
            slow.next = pre;
            pre = slow;
            //移动
            slow = next;
        }
        //此时slow指向中间的节点，且指向的节点还没翻转
        next = slow.next;
        slow.next = pre;
        pre = slow;

        if (fast == null) {
            //长度为奇数
            slow = slow.next;
        }
        while (slow != null && next != null) {
            if (slow.val != next.val) {
                return false;
            }
            slow = slow.next;
            next = next.next;
        }

        if (slow != null || next != null) {
            return false;
        }
        return true;
    }
}
