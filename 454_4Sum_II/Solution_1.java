import java.util.HashMap;
import java.util.List;

public class Solution_1 {

    /**
     * O(n^2)
     * Runtime: 105 ms, faster than 64.05% of Java online submissions for 4Sum II.
     * Memory Usage: 58.8 MB, less than 10.66% of Java online submissions for 4Sum II.
     *
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length * B.length * C.length * D.length == 0) {
            return 0;
        }
        int num = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int c = 0; c < C.length; c++) {
            for (int d = 0; d < D.length; d++) {
                int cdsum = C[c] + D[d];
                if (!map.containsKey(cdsum)) {
                    map.put(cdsum, 1);
                } else {
                    map.put(cdsum, map.get(cdsum) + 1);
                }
            }
        }

        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                int absum = A[a] + B[b];
                if (map.containsKey(-absum)) {
                    num += map.get(-absum);
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();

    }
}
