import java.util.Arrays;

public class Solution_1 {

	/**
	 * Date : 2018/11/01
	 * time complexity : O(n)
	 * space complexity : O(n)
	 *
	 * beats 100%
	 */

	public void moveZeroes(int[] nums) {
		int[] aux = new int[nums.length];

		int count = 0;
		for (int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				aux[i - count] = nums[i];
			}
			else{
				count ++;
			}
		}

		for(int i = 1; i <= count; i++){
			aux[nums.length - i] = 0;
		}

		for(int i = 0; i < nums.length; i++){
			nums[i] = aux[i];
		}

	}

}
