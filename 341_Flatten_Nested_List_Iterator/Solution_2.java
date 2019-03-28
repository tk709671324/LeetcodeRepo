public class Solution_2 {

//    Runtime: 5 ms, faster than 41.03% of Java online submissions for Flatten Nested List Iterator.
//    Memory Usage: 38 MB, less than 81.82% of Java online submissions for Flatten Nested List Iterator.
    public class NestedIterator implements Iterator<Integer> {

        private final Stack<NestedInteger> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; --i) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty()) {
                return false;
            }
            //清楚空List，使得栈顶是一个整数
            NestedInteger curNI;

            while (!stack.isEmpty()) {
                curNI = stack.peek();
                if (curNI.isInteger()) {
                    break;
                }

                List<NestedInteger> curList = stack.pop().getList();
                for (int i = curList.size() - 1; i >= 0; --i) {
                    //空List直接跳过此步；
                    stack.push(curList.get(i));
                }
            }

            return !stack.isEmpty();
        }
    }
}
