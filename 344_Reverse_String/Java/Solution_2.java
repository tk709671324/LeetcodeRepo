public class Solution_2 {

	/**
	 *
	 * Date : 2018/11/6
	 * beats : 100%
	 *
	 * time complexity:O(n)
	 *
	 */
	public String reverseString(String s){

		if(s == null || s.length() == 0){
			return "";
		}

		int l = 0;
		int r = s.length() - 1;
		char[] res = s.toCharArray();
		while(l < r){
			swap(res, l, r);
			l++;
			r--;
		}

		return new String(res);
	}

	public void swap(char[] res, int l, int r){
		char temp = res[l];
		res[l] = res[r];
		res[r] = temp;
	}

	public static void main(String[] args) {

		Solution_2 solution_2 = new Solution_2();
		String s = "\"A man\n" +
				"a plan\n" +
				"a canal: Panama\"";
		String a = solution_2.reverseString(s);
		System.out.println(a);
	}

}
