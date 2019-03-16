import java.util.*;

class Solution {
//    Runtime: 88 ms, faster than 54.71% of Java online submissions for Sequence Reconstruction.
//    Memory Usage: 54.1 MB, less than 65.28% of Java online submissions for Sequence Reconstruction.
public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    HashMap<Integer, Integer> degree = new HashMap();
    HashMap<Integer, HashSet<Integer>> adjMap = new HashMap();

    for (int i : org) {
        degree.put(i, 0);

        HashSet<Integer> set = new HashSet();
        adjMap.put(i, set);
    }
    int n = org.length;
    int c = 0;
    for (int i = 0; i < seqs.size(); i++) {
        List<Integer> seq = seqs.get(i);
        c += seq.size();
        if (seq.size() == 1) {
            int cur = seq.get(0);
            if (!adjMap.containsKey(cur)) {
                return false;
            }
        }
        for (int j = 0; j < seq.size() - 1; j++) {
            int cur = seq.get(j); //如果只有一个元素的话不会进入到for循环中
            int next = seq.get(j + 1);
            if (!adjMap.containsKey(cur) || !degree.containsKey(next)) {
                return false;
            }
            if (adjMap.get(cur).add(next)) {
                //成功添加
                degree.put(next, degree.get(next) + 1);
            }
        }
    }

    if (c < n)
        return false;

    //如果能够构造出不同序列的拓扑排序，说明就不是唯一的
    Queue<Integer> queue = new LinkedList();

    for (int key : degree.keySet())
        if (degree.get(key) == 0)
            queue.add(key);

    int count = 0;
    while (!queue.isEmpty()) {
        if (queue.size() != 1) {
            return false;
        }
        int cur = queue.poll();
        if (org[count] != cur) {
            return false;
        }
        count++;

        for (int next : adjMap.get(cur)) {
            degree.put(next, degree.get(next) - 1);
            if (degree.get(next) == 0) {
                queue.offer(next);
            }
        }
    }

    return count == org.length;
}

}