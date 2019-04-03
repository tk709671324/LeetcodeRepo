public class Solution_1 {

//    Runtime: 1 ms, faster than 96.28% of Java online submissions for Letter Combinations of a Phone Number.
//    Memory Usage: 36.9 MB, less than 89.31% of Java online submissions for Letter Combinations of a Phone Number.
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

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList();
        }

        String firstDigit = digits.substring(0, 1);
        String mapString = phone.get(firstDigit);

        List<String> restCombination = letterCombinations(digits.substring(1));


        List<String> res = new LinkedList<>();
        for (int i = 0; i < mapString.length(); ++i) {
            String head = mapString.substring(i, i + 1);

            if (restCombination.size() == 0) {
                res.add(head);
                continue;
            }

            for (String tail : restCombination) {
                res.add(head + tail);
            }
        }

        return res;
    }
}
