public class Solution_1 {

//    Runtime: 22 ms, faster than 14.14% of Java online submissions for Simplify Path.
//    Memory Usage: 39 MB, less than 58.55% of Java online submissions for Simplify Path.
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }

        String[] strings = path.split("/+");
        Stack<String> fileStack = new Stack<>();
        for (String s : strings) {
            if (s.equals(".") || s.equals("")) {
                continue;
            }
            if (s.equals("..")) {
                if (fileStack.isEmpty()) continue;
                fileStack.pop();
            } else {
                fileStack.push(s);
            }
        }
        if (fileStack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!fileStack.isEmpty()) {
            res.insert(0, fileStack.pop());
            res.insert(0, "/");
        }

        return res.toString();
    }
}
