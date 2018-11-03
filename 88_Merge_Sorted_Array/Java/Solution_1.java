import java.util.Arrays;

public class Solution_1 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		/**
		 * Date : 2018/11/2
		 *
		 *
		 * beats 99.99 %
		 *
		 * time complexity : O(n + m) (n + m是总元素个数)
		 * space complexity : O(m) 申请了辅助空间
		 *
		 *
		 */

		//采用merge sort 的思路
		int[] aux = new int[m];
		for(int i = 0; i < m; i++){
			aux[i] = nums1[i];
		}

		int i = 0;    //i 用于扫描aux
		int j = 0;    //j 用于扫描nums2

		for (int k = 0;k < n + m; k++){
			if(i == m){
				nums1[k] = nums2[j];
				j++;
				continue;
			}
			if(j == n){
				nums1[k] = aux[i];
				i++;
				continue;
			}

			if(aux[i] < nums2[j]){
				nums1[k] = aux[i];
				i++;
			}else {
				nums1[k] = nums2[j];
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] num1 = {1,2,3,0,0,0};
		int[] num2 = {2,5,6};

		Solution_1 solution_1 = new Solution_1();
		solution_1.merge(num1, 3, num2, 3);
		System.out.println(Arrays.toString(num1));
	}
}
