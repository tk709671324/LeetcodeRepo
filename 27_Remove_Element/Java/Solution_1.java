

public class Solution_1 {

	/**
	 * Date : 2018/11/01
	 * time complexity : O(n)
	 * space complexity : O(1)
	 */
	public int removeElement(int[] nums, int val) {

		int  k = 0; // 表示是这个移除val后的数组的长度

		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[k] = nums[i];
				k++;
			}
		}

		return k;
	}

}
