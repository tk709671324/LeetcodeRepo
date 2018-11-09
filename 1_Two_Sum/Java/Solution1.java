import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {

	/**
	 *
	 * Date : 2018/11/9
	 *
	 * time complexity : O(n)
	 *
	 * space complexity : O(n)
	 */

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		//用一个hashmap来存放扫描过但是没找到配对元素， key值是其值，value是其索引
		HashMap<Integer, Integer> sumMap = new HashMap<>();


		for(int i = 0; i < nums.length; i++){
			int partner = target - nums[i];
			if(sumMap.containsKey(partner)){
				res[0] = sumMap.get(partner);
				res[1] = i;
				return res;
			}else {
				sumMap.put(nums[i], i);
			}
		}


		//如果没有解则返回-1
		res[0] = -1;
		res[1] = -1;
		return res;
	}


	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8};
		Solution1 solution1 = new Solution1();
		System.out.println(Arrays.toString(solution1.twoSum(a, 9)));
	}
}
