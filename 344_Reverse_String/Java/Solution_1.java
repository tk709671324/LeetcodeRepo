import java.util.ArrayList;

public class Solution_1 {
	/**
	 *
	 * Date : 2018/11/6
	 * beats : 45.77%
	 *
	 * time complexity:O(n)
	 */
	public String reverseString(String s) {
		StringBuilder res = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--){
			res.append(s.charAt(i));
		}

		return res.toString();
	}

	public static void main(String[] args) {

		Solution_1 solution_1 = new Solution_1();
		String s = "";
		String a = solution_1.reverseString(s);
		System.out.println(a);
	}
}
