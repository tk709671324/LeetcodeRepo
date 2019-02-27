import java.util.ArrayList;
import java.util.Arrays;

public class Solution_1 {

    // Your submission beats 19.00% Submissions!


    public int[] kClosestNumbers(int[] A, int target, int k) {

        if (A == null || A.length == 0) {
            return null;
        }

        int[] ret = new int[k];

        if (target < A[0]) {
            for (int i = 0; i < k; i++) {
                ret[i] = A[i];
            }
            return ret;
        }
        if (target > A[A.length - 1]) {
            for (int i = 0; i < k; i++) {
                ret[i] = A[A.length - 1 - i];
            }
            return ret;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
                end = start + 1;
                break;
            }
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            int startDiff = Math.abs(target - A[start]);
            int endDiff = Math.abs(target - A[end]);

            if (startDiff > endDiff) {
                ret[i] = A[end];
                end++;
            } else if (startDiff < endDiff){
                ret[i] = A[start];
                start--;
            } else {
                ret[i] = A[start];
                i++;
                if (i == k) {
                    break;
                }
                ret[i] = A[end];
                start--;
                end++;
            }

            if (end == A.length) {
                for (int j = i + 1; j < k ; j++) {
                    ret[j] = A[start];
                    start--;
                }
                break;
            }

            if (start == -1) {
                for (int j = i + 1; j < k ; j++) {
                    ret[j] = A[end];
                    end++;
                }
                break;
            }
        }


        return ret;
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] a = {22,25,100,209,1000,1110,1111};
        System.out.println(Arrays.toString(solution_1.kClosestNumbers(a, 15, 5)));
    }
}
