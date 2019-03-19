import java.util.*;

public class Solution_2 {

//    Runtime: 89 ms, faster than 54.72% of Java online submissions for Word Ladder.
//    Memory Usage: 42.3 MB, less than 46.10% of Java online submissions for Word Ladder.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || beginWord == null || endWord == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> filter = new HashSet<>();
        for (String word : wordList) {
            filter.add(word);
        }
        if (!filter.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.offer(beginWord);
        hash.add(beginWord);

        int dis = 0;
        while (!queue.isEmpty()) {
            dis++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return dis;
                }

                List<String> nextWords = getNextWords(cur, filter);
                System.out.print(cur + "'s adj is/are : ");
                for (String word : nextWords) {
                    System.out.print(word + " ");
                }
                System.out.println("");
                for (String nextWord : nextWords) {
                    if (!hash.contains(nextWord)) {
                        queue.add(nextWord);
                        hash.add(nextWord);
                    }
                }
            }

        }

        return 0;

    }

    private List<String> getNextWords(String cur, Set<String> filter) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < cur.length(); i++) {
                String replacedWord = replace(cur, i, c);
                if (filter.contains(replacedWord)) {
                    System.out.println(cur + "can trans to : " + replacedWord);
                    nextWords.add(replacedWord);
                }
            }
        }

        return nextWords;
    }

    private String replace(String org, int index, char rep) {
        char[] chars = org.toCharArray();
        chars[index] = rep;
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution_2 solution_1 = new Solution_2();
        String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(a);
        System.out.println(solution_1.ladderLength("hit", "cog", wordList));
    }
}
