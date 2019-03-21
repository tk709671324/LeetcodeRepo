import java.util.Stack;

public class Solution_1 {

    //    Runtime: 4 ms, faster than 89.79% of Java online submissions for Valid Parentheses.
//    Memory Usage: 36.8 MB, less than 35.75% of Java online submissions for Valid Parentheses.
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] parentheses = s.toCharArray();

        for (char p : parentheses) {
            if (p == '[' || p == '(' || p == '{') {
                stack.push(p);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                if (p == ']') {
                    if (last != '[') {
                        return false;
                    }
                }
                if (p == ')') {
                    if (last != '(') {
                        return false;
                    }
                }
                if (p == '}') {
                    if (last != '{') {
                        return false;
                    }
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

}
