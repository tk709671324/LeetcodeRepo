public class Solution_1 {

    public int lastPosition(int[] nums, int target) {
        // write your code here

        // Your submission beats 45.00% Submissions!

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            index = start;
        }
        if (nums[end] == target) {
            index = end;
        }

        //nums[index] == target
        while (nums[index + 1] == target) {
            index++;
        }

        return index;

    }

}
