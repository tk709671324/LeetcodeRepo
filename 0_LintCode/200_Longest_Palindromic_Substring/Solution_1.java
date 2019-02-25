public class Solution_1 {
    public String longestPalindrome(String s) {

        // Your submission beats 0.20% Submissions!

        if (s == null) {
            return null;
        }

        if (s.length() < 2) {
            return s;
        }

        String ret = s.substring(0,1);

        for (int i = 0; i < s.length(); i++) {
            String singletempPalindrome = expandDetect(s,i, i);
            String doubletempPalindrome = expandDetect(s,i, i + 1);
            String temp = singletempPalindrome.length() >= doubletempPalindrome.length() ? singletempPalindrome : doubletempPalindrome;

            if (temp.length() > ret.length()) {
                ret = temp;
            }
        }

        return ret;
    }

    private String expandDetect(String source, int l, int r) {
        String Detected = "";
        while (l <= r) {
            if (l < 0 || r > source.length() - 1) {
                break;
            }

            if (source.charAt(l) == source.charAt(r)) {
                Detected = source.substring(l, r + 1);
                l--;
                r++;
            } else {
                break;
            }
        }

        return Detected;
    }
}
