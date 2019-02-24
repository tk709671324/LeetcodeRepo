public class Solution_1 {

    public boolean isPalindrome(String s) {

        //Your submission beats 59.60% Submissions!

        if (s == null) {
            return false;
        }

        if (s.length() < 2) {
            return true;
        }

        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        boolean ret = true;
        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            while (!Character.isDigit(left) && !Character.isLetter(left)) {
                 if (r > l) {
                     l++;
                     left = s.charAt(l);
                 } else {
                     break;
                 }
            }
            while (!Character.isDigit(right) && !Character.isLetter(right)) {
                if (r > l) {
                    r--;
                    right = s.charAt(r);
                } else {
                    break;
                }
            }

            if (r > l) {
                if (right != left) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }

        }


        return ret;
    }
}
