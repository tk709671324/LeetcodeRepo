public class Solution_1 {
	public void sortColors(int[] nums) {

		/**
		 * Date : 2018/11/2
		 *
		 * beats 100 %
		 *
		 * time complexity : O(n)
		 * space complexity : O(1）
		 *
		 *
		 */


		//采用Count-Order


		int redCount = 0;    //0
		int whiteCount = 0;    //1
		int blueCount = 0;   //2
		for(int num:nums){
			switch (num){
				case 0:
					redCount++;
					break;
				case 1:
					whiteCount++;
					break;
				case 2:
					blueCount++;
					break;
			}
		}

		for(int i = 0; i < nums.length; i++){
			if(i < redCount){
				nums[i] = 0;
			}else if(i < redCount + whiteCount){
				nums[i] = 1;
			}else{
				nums[i] = 2;
			}
		}

	}
}
