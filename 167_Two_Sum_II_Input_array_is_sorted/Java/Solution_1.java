import java.util.Arrays;

public class Solution_1 {
	public int[] twoSum(int[] numbers, int target) {

		/**
		 * Date : 2018/11/5
		 *
		 * beats 100%
		 *
		 * time complexity : O(n)
		 * space complexity : O(1）
		 */


		//因为是sorted 所以最大的元素肯定在最后面
		//可以使用双指针：
		//两个指针 一个指向最大元素一个指向最小元素然后检查其和；
		//如果两数之和大于target——则需要减小其和，右指针左移
		//同理如果两数之和小于target则左指针右移

		int l = 0;
		int r = numbers.length - 1;

		int[] res = new int[2];
		int test = numbers[l] + numbers[r];

		while(l < r){
			if(test == target){
				res[0] = l + 1;
				res[1] = r + 1;
				return res;
			}
			if(test < target){
				l++;
				test = numbers[l] + numbers[r];
			}else {
				r--;
				test = numbers[l] + numbers[r];
			}
		}

		//题目限定是每次输入是一定有一组为一个解；
		//但是为了程序逻辑上正确还是要在最后返回两个0 表示没有找到解

		res[0] = 0;
		res[1] = 0;
		return res;

	}


	public static void main(String[] args) {

		int[] a = {2,7,11,15};

		Solution_1 solution_1 = new Solution_1();

		int[] res = solution_1.twoSum(a, 9);
		System.out.println(Arrays.toString(res));
	}
}
