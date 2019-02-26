public class Solution_1 {
    public int mountainSequence(int[] nums) {

        //Your submission beats 2.40% Submissions!

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        //let's just image it's a strictly increasing and decreasing mountain.
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }
        }

        return nums[start] > nums[end] ? nums[start] : nums[end];

    }
}
