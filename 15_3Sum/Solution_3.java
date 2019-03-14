import java.util.*;

public class Solution_3 {


//    Runtime: 32 ms, faster than 99.23% of Java online submissions for 3Sum.
//    Memory Usage: 46.6 MB, less than 94.72% of Java online submissions for 3Sum

    //如何去重 ：选定一个元素之后只在它的一边搜索剩下两个数。 也就是说对于每组有序的结果中，以最左/右边的元素做标定点去找剩下两个。
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] A) {
        if (A == null || A.length < 3) {
            return res;
        }

        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            if (A[i] < 0) continue;
            if (i < A.length - 1 && A[i] == A[i + 1]) continue;

            twoSum(A, i - 1, -A[i]);
        }

        return res;
    }

    private void twoSum(int[] A, int right, int target) {
        int l = 0, r = right;
        for (; l <= r; l++) {
            //l 必须是该数的第一个重复元素 -- 为了避免重复
            if (l > 0 && A[l - 1] == A[l]) continue;

            while (l < r && A[r] > target - A[l]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            if (A[l] + A[r] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(A[l]);
                list.add(A[r]);
                list.add(-target);
                res.add(list);
            }
        }
    }
}
