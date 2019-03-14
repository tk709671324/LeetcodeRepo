import java.util.Arrays;

public class Solution_1 {

    public void sortIntegers2(int[] A) {
        // write your code here
        int n = A.length;
        mergeSort(A, 0, n - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(nums, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = aux[j - l];
                j++;
            } else if (j > r) {
                nums[k] = aux[i - l];
                i++;
            } else if (aux[i -l] < aux[j - l]) {
                nums[k] = aux[i - l];
                i++;
            } else {
                nums[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] A = {3,2,1};
        solution_1.sortIntegers2(A);
        System.out.println(Arrays.toString(A));
    }
}
