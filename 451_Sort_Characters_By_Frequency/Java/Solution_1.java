
import java.util.*;

public class Solution_1 {
    /*
    Date : 2018/11/18
    Time : O(nlogn) + 4O(n)
    Space : O(n)
     */
    public String frequencySort(String s) {

        if (s == null || s.length() == 0){
            return "";
        }

        char[] charS = s.toCharArray();    //O(n)

        HashMap<Character, Integer> record = new HashMap<>(s.length());

        for (char c : charS) {    //O(n)
            if (record.containsKey(c)) {
                record.put(c, record.get(c) + 1);
            }else {
                record.put(c, 1);
            }
        }

        Iterator<Character> iterator = record.keySet().iterator();
        ArrayList<String> sub = new ArrayList<>(record.size());

        while (iterator.hasNext()) {    //O(n) ： 因为会建立的字符串总长度为n
            char c = iterator.next();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < record.get(c); i++){
                res.append(c);    //StringBuilder 的 append 构造字符串时间复杂度为 O(n)
            }
            sub.add(res.toString());
        }

        Collections.sort(sub, new LengthComparator());    //默认排序 O(nlogn)

        StringBuilder ret = new StringBuilder();
        for (String str : sub) {    //O(n)
            ret.append(str);
        }

        return ret.toString();
    }

    private class LengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return -1;
            }else if (o1.length() == o2.length()) {
                return 0;
            }else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {

        Solution_1 solution_1 = new Solution_1();

        System.out.println(solution_1.frequencySort("aabbbbdAAAHDddssjejf"));
    }


}
