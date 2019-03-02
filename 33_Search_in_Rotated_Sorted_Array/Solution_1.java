public class Solution_1 {
    public int search(int[] nums, int target) {

//        Runtime: 5 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
//        Memory Usage: 40.1 MB, less than 10.66% of Java online submissions for Search in Rotated Sorted Array.

        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        if (target < nums[0] && target > nums[nums.length - 1]) {
            return -1;
        }

        int pivot;
        int start = 0, end = nums.length - 1;
        if (nums[end] > nums[start]) {
            //如果没有翻转则直接返回
            return binarySearch(nums, start, end, target);
        } else {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > nums[start]) {
                    //在上升部分
                    start = mid;
                } else {
                    //在下降部分
                    end = mid;
                }
            }
        }



        pivot = end;

        if (target >= nums[0]) {
            start = 0;
            end = pivot - 1;
            return binarySearch(nums, start, end, target);
        } else {
            start = pivot;
            end = nums.length - 1;
            return binarySearch(nums, start, end, target);
        }

    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
