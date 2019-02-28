public class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//        Runtime: 20 ms, faster than 99.91% of Java online submissions for Add Two Numbers II.
//        Memory Usage: 47.5 MB, less than 35.24% of Java online submissions for Add Two Numbers II.
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);

        ListNode ret_head = new ListNode((reversedL1.val + reversedL2.val) % 10);
        ListNode ret_tail = ret_head;
        ListNode currL1 = reversedL1.next;
        ListNode currL2 = reversedL2.next;
        boolean isCarried = (reversedL1.val + reversedL2.val) >= 10;

        while (currL1 != null || currL2 != null) {
            if (currL1 == null) {
                if (isCarried) {
                    ret_tail.next = new ListNode((currL2.val + 1) % 10);
                    ret_tail = ret_tail.next;
                    isCarried = (currL2.val + 1) >= 10;
                } else {
                    ret_tail.next = new ListNode(currL2.val);
                    ret_tail = ret_tail.next;
                }

                currL2 = currL2.next;
            } else if (currL2 == null) {
                if (isCarried) {
                    ret_tail.next = new ListNode((currL1.val + 1) % 10);
                    ret_tail = ret_tail.next;
                    isCarried = (currL1.val + 1) >= 10;
                } else {
                    ret_tail.next = new ListNode(currL1.val);
                    ret_tail = ret_tail.next;
                }

                currL1 = currL1.next;
            } else {
                if (isCarried) {
                    ret_tail.next = new ListNode((currL1.val + currL2.val + 1) % 10);
                    isCarried = (currL1.val + currL2.val + 1) >= 10;
                    ret_tail = ret_tail.next;
                    currL1 = currL1.next;
                    currL2 = currL2.next;
                } else {
                    ret_tail.next = new ListNode((currL1.val + currL2.val) % 10);
                    isCarried = (currL1.val + currL2.val) >= 10;
                    ret_tail = ret_tail.next;
                    currL1 = currL1.next;
                    currL2 = currL2.next;
                }
            }
        }
        if (isCarried) {
            ret_tail.next = new ListNode(1);
        }
        ListNode ret = reverseList(ret_head);

        return ret;
    }

    private ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head; //需要翻转的节点
        ListNode next = curr.next;

        while (next != null) {
            curr.next = pre; //翻转当前节点

            //往后移动
            pre = curr;
            curr = next;
            next = curr.next;
        }

        curr.next = pre;

        return curr;
    }
}
