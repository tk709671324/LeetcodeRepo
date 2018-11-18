import java.util.HashMap;

public class Solution_1 {
    /*
    Date : 2018/11/18
    Time : O(n)
    Space : O(n)
     */
    public boolean isIsomorphic(String s, String t) {

        //一个字母只能转换为另一个字母， 同时一个字母转换自同一个字母
        //转换字母之间是一对一的关系

        if (s.length() != t.length()) { return false; }

        char[] srcChar = s.toCharArray();
        char[] tranChar = t.toCharArray();

        HashMap<Character, Character> srcMap = new HashMap<>(srcChar.length);
        HashMap<Character, Character> tranMap = new HashMap<>(srcChar.length);

        for (int i = 0; i < srcChar.length; i ++) {
            if (!srcMap.containsKey(srcChar[i])) {
                if (tranMap.containsKey(tranChar[i])) {
                    return false;
                }else {
                    srcMap.put(srcChar[i], tranChar[i]);
                    tranMap.put(tranChar[i], srcChar[i]);
                }
            }else {
                if (srcMap.get(srcChar[i]) != tranChar[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
