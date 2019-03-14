import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_3 {
    public void sortIntegers2(int[] A) {
        //堆排序
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            heap.offer(A[i]);
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = heap.poll();
        }
    }

    public static void main(String[] args) {
        Solution_3 solution_2 = new Solution_3();
        int[] A = {3,2,4,56,7,4,3,6,7,3,4,6,9,2,1};
        solution_2.sortIntegers2(A);
        System.out.println(Arrays.toString(A));
    }
}
