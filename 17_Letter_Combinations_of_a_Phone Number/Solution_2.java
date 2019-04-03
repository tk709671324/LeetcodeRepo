public class Solution_2 {

    //backtrack写法
//    Runtime: 1 ms, faster than 96.28% of Java online submissions for Letter Combinations of a Phone Number.
//    Memory Usage: 37.1 MB, less than 83.64% of Java online submissions for Letter Combinations of a Phone Number.
    final private Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    private final List<String> output = new LinkedList<>();

    private void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        }
        else {
            String digit = next_digits.substring(0, 1);
            String mapping = phone.get(digit);
            for (int i = 0; i < mapping.length(); ++i) {
                String head = mapping.substring(i, i + 1);
                backtrack(combination + head, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }
}
