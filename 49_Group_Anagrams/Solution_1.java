import java.util.*;

public class Solution_1 {
    /**
     *
     * Runtime: 16 ms, faster than 66.66% of Java online submissions for Group Anagrams.
     * Memory Usage: 43.4 MB, less than 100.00% of Java online submissions for Group Anagrams.
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }

        List<List<String>> ret = new LinkedList<>();

        HashMap<String, List> listMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (listMap.isEmpty()) {
                addList(listMap, strs[i]);
            } else {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                if (listMap.containsKey(key)) {
                    listMap.get(key).add(strs[i]);
                } else {
                    addList(listMap, strs[i]);
                }
            }
        }

        Iterator<List> i = listMap.values().iterator();
        while (i.hasNext()) {
            ret.add(i.next());
        }
        return ret;
    }

    private void addList(HashMap<String, List> map, String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        if (map.containsKey(key)) {
            System.out.println("Already contained");
        } else {
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"tea", "eat"};
        Solution_1 solution_1 = new Solution_1();
        solution_1.groupAnagrams(strs);
    }

}
