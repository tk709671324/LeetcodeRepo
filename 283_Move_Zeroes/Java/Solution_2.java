import java.util.Arrays;

public class Solution_2 {

	/**
	 * Date : 2018/11/01
	 * time complexity : O(n)
	 * space complexity : O(1)
	 */


	public void moveZeroes(int[] nums){

		int i = 0;
		int k = 0;

		//Loop Invariant: nums[0...k-1] are non-zero elements with the original order.
		for(;i < nums.length; i++){
			if(nums[i] != 0){
				nums[k] = nums[i];
				k++;
			}
		}

		for(; k < nums.length; k++){
			nums[k] = 0;
		}
	}

}
