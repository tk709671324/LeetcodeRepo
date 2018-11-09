import java.util.HashMap;

public class Solution_2 {

	public int[] twoSum(int[] nums, int target){

		HashMap<Integer, Integer> recordMap = new HashMap<>(nums.length);

		for (int i = 0; i < nums.length; i++){
			recordMap.put(nums[i], i);
		}

		for (int index = 0; index < nums.length; index++){
			Integer partner = recordMap.get(target - nums[index]);

			if(partner != null && partner != index){
				int[] res = {index, partner};
				return res;
			}
		}

		int[] res = {-1, -1};
		return res;
	}
}
