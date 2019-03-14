import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_2 {

//    Runtime: 9 ms, faster than 52.79% of Java online submissions for Kth Largest Element in an Array.
//    Memory Usage: 39 MB, less than 25.00% of Java online submissions for Kth Largest Element in an Array.
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(maxHeapCom);

        //O(n)
        for (int i = 0; i < nums.length; i++) {
            maxheap.offer(nums[i]);
        }
        int res = 0;

        //O(klogn)
        for (int i = 0; i < k; i++) {
            res = maxheap.poll();
        }

        return res;
    }

    private Comparator<Integer> maxHeapCom = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1, o2);
        }
    };
}
