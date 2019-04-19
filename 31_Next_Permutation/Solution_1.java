public class Solution_1 {

//    Runtime: 1 ms, faster than 99.70% of Java online submissions for Next Permutation.
//    Memory Usage: 37.4 MB, less than 94.57% of Java online submissions for Next Permutation.
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2 ) {
            return;
        }

        int index = nums.length - 1;
        while (index != 0 && nums[index] <= nums[index - 1]) {
            index--;
        }
        if (index != 0) {
            int j = nums.length - 1;
            while (index <= j && nums[index - 1] >= nums[j]) {
                j--;
            }
            swap(nums, index - 1, j);
        }
        reverse(nums, index, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
