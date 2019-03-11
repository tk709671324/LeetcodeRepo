public class Solution_1 {
//    Runtime: 122 ms, faster than 87.83% of Java online submissions for Two Sum III - Data structure design.
//    Memory Usage: 49.2 MB, less than 81.07% of Java online submissions for Two Sum III - Data structure design.
    class TwoSum {
        private final HashMap<Integer, Integer> map;
        private int size;
        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap();
            size = 0;
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {

            Iterator<Integer> i = map.keySet().iterator();
            while (i.hasNext()) {
                int v = i.next();
                int need = value - v;
                if (need == v) {
                    if (map.get(need) <= 1) {
                        continue;
                    } else {
                        return true;
                    }
                } else if (map.containsKey(need)) {
                    return true;
                }
            }
            return false;
        }
    }
}
