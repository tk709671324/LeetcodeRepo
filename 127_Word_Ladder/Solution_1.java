import java.util.*;

class Solution_1 {

//    Runtime: 193 ms, faster than 38.71% of Java online submissions for Word Ladder.
//    Memory Usage: 41.2 MB, less than 62.89% of Java online submissions for Word Ladder.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

        int n = wordList.size();
        ArrayList<String> allWords = new ArrayList<>();
        allWords.addAll(wordList);
        allWords.add(0, beginWord);
        int endIndex = 0;
        while (endIndex < n + 1) {
            if (allWords.get(endIndex).equals(endWord)) {
                break;
            }
            endIndex++;
        }
        if (endIndex == n + 1) {
            return 0;
        }


        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        //O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (canTrans(allWords.get(i), allWords.get(j))) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        int res = shortestBFS(adjList, endIndex);
        return res;
    }

    private boolean canTrans(String one, String two) {
        if (one.length() != two.length()) {
            return false;
        }

        boolean canTran = false;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                if (canTran) {
                    return false;
                } else {
                    canTran = true;
                }
            }
        }

        return canTran;
    }

    //O(E + V)
    private int shortestBFS(List<Integer>[] adjList, int endIndex) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> filter = new HashSet<>();
        queue.offer(0);
        filter.add(0);

        int dis = 0;
        while (!queue.isEmpty()) {
            dis++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int cur = queue.poll();

                if (cur == endIndex) {
                    return dis;
                }

                for (int adj : adjList[cur]) {
                    if (!filter.contains(adj)) {
                        queue.offer(adj);
                        filter.add(adj);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(a);
        System.out.println(solution_1.ladderLength("hit", "cog", wordList));
    }
}