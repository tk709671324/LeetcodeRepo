import java.util.HashSet;
import java.util.Vector;

public class Solution_1 {

	/**
	 * Date : 2018/11/6
	 *
	 * beats : 59.93
	 *
	 * ps 试过了使用switch函数直接计算更加快速
	 */
	private final static HashSet<Character> VOWELS = new HashSet<>();
	{
		VOWELS.add('a');
		VOWELS.add('e');
		VOWELS.add('i');
		VOWELS.add('o');
		VOWELS.add('u');
		VOWELS.add('A');
		VOWELS.add('E');
		VOWELS.add('O');
		VOWELS.add('I');
		VOWELS.add('U');

	}
 	/**
	 *
	 * Date : 2018/11/6
	 *
	 * beat : 76.01%
	 */
	public String reverseVowels(String s) {
		if(s == null || s.length() == 0){
			return "";
		}



		char[] str = s.toCharArray();
		int l = newxVowels(str, 0);
		int r = prevVowels(str, str.length - 1);

		while(l < r){
			swap(str, l, r);
			l = newxVowels(str, l + 1);
			r = prevVowels(str, r - 1);
		}

		return new String(str);
	}

	private int newxVowels(char[] charArray, int index){ //包括index
		for (int i = index; i < charArray.length; i++){
			char temp = charArray[i];
			if(isVowels(temp)){
				return i;
			}
		}

		return charArray.length;
	}

	private int prevVowels(char[] charArray, int index){
		for (int i = index; i >= 0; i--){
			char temp = charArray[i];
			if(isVowels(temp)){
				return i;
			}
		}

		return -1;
	}

	private boolean isVowels(char i){

		if(VOWELS.contains(i)){
			return true;
		}

		return false;
	}

	private void swap(char[] res, int l, int r){
		char temp = res[l];
		res[l] = res[r];
		res[r] = temp;
	}


	public static void main(String[] args) {
		Solution_1 solution_1 = new Solution_1();
		System.out.println(solution_1.reverseVowels("aA"));
	}
}
