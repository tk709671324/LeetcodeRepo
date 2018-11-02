import java.util.Arrays;

public class Solution_1 {

	/**
	 *
	 * Data : 2018/11/2
	 *
	 * beats 60.65%
	 *
	 * ps. 本题审题不仔细没有看到sorted 字样，第一时间想到用二分查找。保留原样用于警示。
	 */
	public int removeDuplicates(int[] nums) {

		int k = 1;
		for (int i = 1; i < nums.length; i++){
			if(!containsBinarySearch(nums, nums[i], 0, k - 1)){
				nums[k] = nums[i];
				k++;
			}
		}


		return k;
	}

	public boolean containsBinarySearch(int []arr, int val, int l, int r){


		//二分搜索在[l,r]的范围搜索

		while(l <= r){ //根据loop invariant [l,r]中查找，l==r的情况下也有意义
			int mid = l + (r - l)/2;
			if(val == arr[mid]){
				return true;
			}
			if(val < arr[mid]){
				r = mid - 1;
			}
			if(val > arr[mid]){
				l = mid + 1;
			}
		}


		return false;
	}


	public static void main(String[] args) {

		int a[] = {0,0,1,1,1,2,2,3,3,4};
		Solution_1 solution_1 = new Solution_1();
		System.out.println(solution_1.removeDuplicates(a));
		System.out.println(Arrays.toString(a));

	}
}
