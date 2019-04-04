public class Solution_1 {

//    Runtime: 2 ms, faster than 96.10% of Java online submissions for Combinations.
//    Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Combinations.

    private int n;
    private int k;
    private List<List<Integer>> output = new LinkedList<>();

    private void backtrack(int first, LinkedList<Integer> combination) {
        if (combination.size() == k) {
            output.add(new LinkedList(combination));
            return;
        }

        for (int i = first; i <= n + 1 - (k - combination.size()); ++i) {

            combination.add(i);
            backtrack(i + 1, combination);
            combination.removeLast();
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList());
        return output;
    }
}
