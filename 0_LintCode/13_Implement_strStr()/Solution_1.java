

public class Solution_1 {


    // Your submission beats 23.40% Submissions!

    public int strStr(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }

        if (source.length() == 0 || target.length() == 0 || target.length() > source.length()) {
            return -1;
        }

        char start = target.charAt(0);
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == start) {
                if (source.length() - i < target.length()) {
                    return -1;
                } else {
                    if (isstrStr(source, target, i)) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    private boolean isstrStr(String source, String target, int index) {
        for (int i = 0; i < target.length(); i++) {
            int sourceIndex = i + index;
            if (source.charAt(sourceIndex) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
