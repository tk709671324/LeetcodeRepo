public class Solution_2 {

//    Runtime: 5 ms, faster than 90.13% of Java online submissions for Merge k Sorted Lists.
//    Memory Usage: 45.4 MB, less than 6.35% of Java online submissions for Merge k Sorted Lists.
    class NodeComparator implements Comparator {
        public int compare(Object obj1, Object obj2) {
            ListNode one = (ListNode)obj1;
            ListNode two = (ListNode)obj2;
            if (one.val > two.val) {
                return 1;
            }
            if (one.val == two.val) {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new NodeComparator());
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (ListNode ln : lists) {
            if (ln == null) continue;
            pq.offer(ln);
        }

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = cur.next;

            minNode = minNode.next;
            if (minNode != null) {
                pq.offer(minNode);
            }
        }

        return dummyHead.next;
    }
}
