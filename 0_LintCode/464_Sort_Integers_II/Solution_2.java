import java.util.Arrays;

public class Solution_2 {
    public void sortIntegers2(int[] A) {
        // write your code here
        int n = A.length;
        quickSort(A, 0, n - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = pivot(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);

    }

    private int pivot(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }

        int compareValue = nums[l];
        int left = l; //指向最后一个小于等于compareValue的元素；
        int right = r + 1; //指向最后一个比CV大的元素
        while (left + 1 != right) {
            if (nums[left + 1] <= compareValue) {
                left++;
            } else {
                swap(nums, left + 1, right - 1);
                right--;
            }
        }

        swap(nums, left, l);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution_2 solution_2 = new Solution_2();
        int[] A = {3,2,4,56,7,4,3,6,7,3,4,6,9,2,1};
        solution_2.sortIntegers2(A);
        System.out.println(Arrays.toString(A));
    }
}
