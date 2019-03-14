public class Solution_1 {
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int l = -1, r = nums.length; //l, r 分别指向最后一个满足条件的元素
        while (l < r) {
            if (l == nums.length - 1 || r == 0) break;//两种极端情况
            if (nums[l + 1] < k) {
                l++;
            } else {
                swap(nums, l + 1, r - 1);
                r--;
            }
        }

        return l + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
