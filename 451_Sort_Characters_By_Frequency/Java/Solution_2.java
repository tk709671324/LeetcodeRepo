public class Solution_2 {
    //基本思想和solution_1相似，做出了一些优化

    /*
    Date : 2018/11/18
    Time : O(n)
    Space : O(1)    //常数

    beats : 100.00%
     */

    public String frequencySort(String s) {

        if (s.length() < 3) {
            return s;
        }

        char[] chars = s.toCharArray();
        int[] record = new int[128];    //统计字符出现的频率

        for (char c : chars) {
            record[c]++;
        }


        int pos = 0;

        while (pos < chars.length) {
            char max = 0;    //最大频率的索引（即对应的ASCii值）
            for (int i = 0; i < record.length; i ++){
                if (record[i] > record[max]) {
                    max = (char)i;
                }
            }

            while (record[max] != 0) {
                chars[pos++] = max;
                record[max]--;
            }
        }

        return new String(chars);

    }

    public static void main(String[] args) {
        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.frequencySort("sadfajhdbvadva"));
    }

//    public String frequencySort(String s) {
//        if (s.length() <= 2) return s;
//        char[] record = new char[128];
//        char[] res = s.toCharArray();
//        for (char c : res) record[c]++;
//        int pos = 0;
//        while (pos < res.length) {
//            char max = 0;
//            for (char i = 0; i < record.length; i++) {
//                if (record[i] > record[max]) max = i;
//            }
//            while (record[max] > 0) {
//                res[pos++] = max;
//                record[max]--;
//            }
//        }
//        return new String(res);
//    }


}
