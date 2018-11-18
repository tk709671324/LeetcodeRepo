import java.util.HashMap;

public class Solution_1 {

        /*
        Date : 2018/11/18
        Time : O(n)
        Space : O(n)
        beats : 98.26%
         */
    public boolean wordPattern(String pattern, String str) {
        //明确map的查找时间复杂度是：
        //根据key找value是O(1)
        //根据value找key是O(n) 遍历
        //java要表达题目要求的这种一对一关系的时候只能使用两张表；

        String[] words = str.split(" ");
        char[] patternChar = pattern.toCharArray();

        if (words.length != patternChar.length) {
            return false;
        }

        HashMap<String, Character> strMap = new HashMap<>();
        HashMap<Character, String> patMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!strMap.containsKey(words[i])) {
                if (patMap.containsKey(patternChar[i])) {
                    return false;
                }else {
                    strMap.put(words[i], patternChar[i]);
                    patMap.put(patternChar[i], words[i]);
                }
            }else {
                if (!patMap.containsKey(patternChar[i])) {
                    return false;
                }else {
                    if (!strMap.get(words[i]).equals(patternChar[i])) {
                        return false;
                    }
                }
            }
        }

        return true;

    }

}
