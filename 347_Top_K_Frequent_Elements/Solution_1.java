public class Solution_1 {

//    Runtime: 17 ms, faster than 57.43% of Java online submissions for Top K Frequent Elements.
//    Memory Usage: 41 MB, less than 62.04% of Java online submissions for Top K Frequent Elements.

    Class FrequentComparator implements Comparator {
        private final HashMap<Integer, Integer> map;
        FrequentComparator(HashMap map) {
            this.map = map;
        }
        public int compare(Object obj1, Object obj2) {
            assert (map.containsKey(obj1) && map.containsKey(obj2));

            return map.get(obj2) - map.get(obj1);
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue(new FrequentComparator(map));
        for (int i : map.keySet()) {
            pq.offer(i);
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }

        return res;
    }
}
