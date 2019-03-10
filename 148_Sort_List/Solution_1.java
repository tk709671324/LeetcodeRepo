public class Solution_1 {
    public ListNode sortList(ListNode head) {
//        Runtime: 4 ms, faster than 86.16% of Java online submissions for Sort List.
//        Memory Usage: 41.6 MB, less than 21.37% of Java online submissions for Sort List.

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, middle = head, tail = head;

        //将链表切割成两段
        while (tail != null && tail.next != null) {
            pre = middle;
            middle = middle.next;
            tail = tail.next.next;
        }

        pre.next = null; //切割操作

        ListNode listOne = sortList(head);
        ListNode listTwo = sortList(middle);

        return merge(listOne, listTwo);
    }

    private ListNode merge(ListNode listOne, ListNode listTwo) {


        ListNode dummyHead = new ListNode(0), cur = dummyHead;

        while (listOne != null && listTwo != null) {
            if (listOne.val < listTwo.val) {
                cur.next = listOne;
                listOne = listOne.next;
            } else {
                cur.next = listTwo;
                listTwo = listTwo.next;
            }
            cur = cur.next;
        }

        if (listOne != null) {
            cur.next = listOne;
        }
        if (listTwo != null) {
            cur.next = listTwo;
        }

        return dummyHead.next;

    }
}
