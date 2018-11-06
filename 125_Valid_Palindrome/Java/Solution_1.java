

public class Solution_1 {

	/**
	 *
	 * Date : 2018/11/5
	 *
	 * beats 38.40%
	 * time complexity : O(n)
	 * space complexity : O(1)
	 *
	 */
	public boolean isPalindrome(String s) {

		//在本题中全部转化为小写就可以达成无视大小写的功能
		s = s.toLowerCase();
		int l = nextAlphaNumeric(s, 0);
		int r = prevAlphaNumeric(s, s.length() - 1);

		while(l < r){
			if(s.charAt(l) != s.charAt(r)){
				return false;
			}
			l = nextAlphaNumeric(s, l + 1);
			r = prevAlphaNumeric(s, r - 1);
		}

		return true;
	}

	private int nextAlphaNumeric(String s, int index){

		for(int i = index; i < s.length() - 1; i++){
			char c = s.charAt(i);
			if((Character.isLetter(c)) || (Character.isDigit(c))){
				return i;
			}
		}

		return s.length();
	}

	private int prevAlphaNumeric(String s, int index){

		for(int i = index; i >= 0; i--){
			char c = s.charAt(i);
			if((Character.isLetter(c)) || (Character.isDigit(c))){
				return i;
			}
		}

		return s.length();
	}

	public static void main(String[] args) {
		String a = "ab";
		Solution_1 solution_1 = new Solution_1();
		System.out.println(solution_1.isPalindrome(a));
	}
}