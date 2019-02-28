import java.util.Stack;

public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

//        Runtime: 25 ms, faster than 77.39% of Java online submissions for Add Two Numbers II.
//        Memory Usage: 48.1 MB, less than 22.84% of Java online submissions for Add Two Numbers II.


        if (l1 == null && l2 == null) {
            return null;
        }

        Stack<Integer> stackL1 = new Stack<>();
        Stack<Integer> stackL2 = new Stack<>();

        ListNode headL1 = l1;
        ListNode headL2 = l2;

        while (headL1 != null) {
            stackL1.push(headL1.val);
            headL1 = headL1.next;
        }
        while (headL2 != null) {
            stackL2.push(headL2.val);
            headL2 = headL2.next;
        }

        ListNode retDummyHead = new ListNode(0);
        boolean isCarried = false;
        while (!stackL1.empty() || !stackL2.empty()) {
            if (isCarried) {
                int val = 0;
                if (!stackL1.empty()) val += stackL1.pop();
                if (!stackL2.empty()) val += stackL2.pop();
                ListNode newDigit = new ListNode((val + 1) % 10);
                isCarried = ((val + 1) >= 10);
                newDigit.next = retDummyHead.next;
                retDummyHead.next = newDigit;
            } else {
                int val = 0;
                if (!stackL1.empty()) val += stackL1.pop();
                if (!stackL2.empty()) val += stackL2.pop();
                ListNode newDigit = new ListNode(val % 10);
                isCarried = (val >= 10);
                newDigit.next = retDummyHead.next;
                retDummyHead.next = newDigit;
            }
        }

        if (isCarried) {
            retDummyHead.val = 1;
        }

        return (retDummyHead.val == 0) ? retDummyHead.next : retDummyHead;
    }
}
