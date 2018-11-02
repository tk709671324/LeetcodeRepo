import java.util.Arrays;

public class Solution_2 {


	/**
	 * Date : 2018/11/1
	 *
	 * beats 90.90%
	 */
	public int removeDuplicates(int[] nums){

		//要求最终nums数组的前面一段为不重复的，且返还该不重复段的长度
		//我们可以扫描整个数组，遇见不重复的（在sorted array中，不重复的以为着该元素与前一个元素不相同）元素则在不重复的段落尾部添加该元素


		int duplicatedElementNum = 0;  //用于记载重复元素的个数

		for (int i = 1; i < nums.length; i++){ //扫描至num[i] 判断其跟前一个元素是否相等
			if(nums[i - 1] == nums[i]){
				duplicatedElementNum ++; //如果相等则重复元素个数加一
			}
			else { //如果不相等，则把该元素添加到不重复段的尾部；前面一共有 i 个元素（注意i为index），其中duplicatedElementNum个重复元素
				//则前面不重复段的长度为 i - duplicatedElementNum
				//要在 index 为 i - duplicatedElementNum 处赋值（因为）
				nums[i - duplicatedElementNum] = nums[i];
			}
		}

		return nums.length - duplicatedElementNum;
	}

	public static void main(String[] args) {

		int a[] = {0,0,1,1,1,2,2,3,3,4};
		Solution_2 solution_2 = new Solution_2();
		System.out.println(solution_2.removeDuplicates(a));
		System.out.println(Arrays.toString(a));

	}

}
