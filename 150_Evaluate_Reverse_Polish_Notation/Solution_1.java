import java.util.Stack;

public class Solution_1 {

    //这个写法让程序更加美观，但是效率较低（非时间复杂度
//    Runtime: 15 ms, faster than 10.18% of Java online submissions for Evaluate Reverse Polish Notation.
//    Memory Usage: 39.8 MB, less than 5.03% of Java online submissions for Evaluate Reverse Polish Notation.
    public int evalRPN(String[] tokens) {

        Stack<Integer> integerStack = new Stack<>();

        for (String token : tokens) {
            if (isValidInteger(token)) {
                integerStack.push(Integer.parseInt(token));
            } else {
                int opRight = integerStack.pop();
                int opLeft = integerStack.pop();
                int res = cal(token, opLeft, opRight);
                integerStack.push(res);
            }
        }

        return integerStack.pop();
    }

    private boolean isValidInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private int cal(String op, int left, int right) {
        if (op.equals("+")) {
            return left + right;
        }
        if (op.equals("-")) {
            return left - right;
        }
        if (op.equals("*")) {
            return left * right;
        }

        return left / right;
    }


    public int anotherEvalRPN(String[] tokens) {

        //Runtime: 5 ms, faster than 94.17% of Java online submissions for Evaluate Reverse Polish Notation.
        //Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Evaluate Reverse Polish Notation.

        int opLeft, opRight;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                opRight = stack.pop();
                opLeft = stack.pop();
                stack.push(opLeft + opRight);
            } else if (token.equals("-")) {
                opRight = stack.pop();
                opLeft = stack.pop();
                stack.push(opLeft - opRight);
            } else if (token.equals("*")) {
                opRight = stack.pop();
                opLeft = stack.pop();
                stack.push(opLeft * opRight);
            } else if (token.equals("/")) {
                opRight = stack.pop();
                opLeft = stack.pop();
                stack.push(opLeft / opRight);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
