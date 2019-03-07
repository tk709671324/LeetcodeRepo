public class Solution_1 {

    public int strStr(String haystack, String needle) {

//        Runtime: 5 ms, faster than 56.44% of Java online submissions for Implement strStr().
//                Memory Usage: 38.5 MB, less than 38.30% of Java online submissions for Implement strStr().
        if(needle == null) {
            return -1;
        }
        int m = needle.length();
        if(m == 0 && haystack != null) {
            return 0;
        }

        if(haystack == null) {
            return -1;
        }
        int n = haystack.length();
        if(n == 0) {
            return -1;
        }

        // mod could be any big integer
        // just make sure mod * 33 wont exceed max value of int.
        int mod = Integer.MAX_VALUE / 33;
        int hash_target = 0;

        // 33 could be something else like 26 or whatever you want
        for (int i = 0; i < m; ++i) {
            hash_target = (hash_target * 33 + needle.charAt(i)) % mod;
            if (hash_target < 0) {
                hash_target += mod;
            }
        }

        int m33 = 1;
        for (int i = 0; i < m - 1; ++i) {
            m33 = m33 * 33 % mod;
        }

        int value = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= m) {
                value = (value - m33 * (haystack.charAt(i - m))) % mod;
            }

            value = (value * 33 + haystack.charAt(i)) % mod;
            if (value < 0) {
                value += mod;
            }

            if (i >= m - 1 && value == hash_target) {
                // you have to double check by directly compare the string
                if (needle.equals(haystack.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;

    }


}
