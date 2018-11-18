import java.util.HashMap;

public class Solution_1 {
    public boolean isAnagram(String s, String t) {

        /*
        Date: 2017/11/17
        Time Complexity : O(n)
        Space Complexity : O(n)
        beats : 14.24%

         */

        if (s.length() != t.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        HashMap<Character, Integer> record = new HashMap<>(s.length());

        for (char aChar : charS) {
            if (!record.containsKey(aChar)) {
                record.put(aChar, 1);
            } else {
                record.put(aChar, record.get(aChar) + 1);
            }
        }

        for (char aCharT : charT) {
            if (!record.containsKey(aCharT) || record.get(aCharT) == 0) {
                return false;
            } else {
                record.put(aCharT, record.get(aCharT) - 1);
            }
        }

        return true;
    }
}
