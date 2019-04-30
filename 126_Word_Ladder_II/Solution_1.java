public class Solution_1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new LinkedList<>();
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, adj, distance);

        List<String> path = new LinkedList<>();
        dfs(beginWord, endWord, ladders, distance, adj, path);

        return ladders;
    }

    private void bfs(String begin, String end,
                     Set<String> dict,
                     Map<String, List<String>> adj,
                     Map<String,
                             Integer> distance) {
        for (String s : dict) {
            adj.put(s, new LinkedList<String>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        distance.put(begin, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            List<String> nextWords = expand(cur, dict);

            for (String nextWord : nextWords) {
                adj.get(nextWord).add(cur);
                if (!distance.containsKey(nextWord)) {
                    distance.put(nextWord, distance.get(cur) + 1);
                    queue.offer(nextWord);
                }
            }
        }
    }

    private List<String> expand(String word, Set<String> dict) {
        List<String> nextWords = new LinkedList<>();
        int n = word.length();
        for (int i = 0; i < n; ++i) {
            for (char c = 'a'; c <= 'z'; ++c) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = word.substring(0, i) + c + word.substring(i + 1, n);
                if (dict.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
        }

        return nextWords;
    }
    // dfs(beginWord, endWord, ladders, distance, adj, path);
    private void dfs(String begin, String end,
                     List<List<String>> ladders,
                     Map<String, Integer> distance,
                     Map<String, List<String>> adj,
                     List<String> path) {
        path.add(begin);
        if (begin.equals(end)) {
            ladders.add(new LinkedList(path));
        }
        else {
            for (String next : adj.get(begin)) {
                //因为有的单词可能是不可达的
                if (distance.containsKey(next) && distance.get(next) == distance.get(begin) + 1) {
                    dfs(next, end, ladders, distance, adj, path);
                }
            }
        }
        path.remove(path.size() - 1);//回溯
    }
}
