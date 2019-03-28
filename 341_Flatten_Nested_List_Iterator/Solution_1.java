public class Solution_1 {
    public class NestedIterator implements Iterator<Integer> {
        class CurNestedList {
            //代表了即将处理的NestedInteger，index代表开始处理的索引
            //包括index
            //每发现一个List就要把当前处理的下一个元素推入栈然后开始处理发现的List。
            List<NestedInteger> list;
            int index;

            CurNestedList() {
                list = null;
                index = -1;
            }

            CurNestedList(List<NestedInteger> list, int index) {
                this.list = list;
                this.index = index;
            }
        }

        private final Stack<CurNestedList> stack;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            if (nestedList.size() > 0) {
                stack.push(new CurNestedList(nestedList, 0));
            }
        }

        @Override
        public Integer next() {
            //根据hasNext的处理，栈顶弹出来的必将是一个整数
            CurNestedList cur = stack.pop();
            if (cur.index + 1 < cur.list.size()) {
                cur.index +=1;
                stack.push(cur);
                return cur.list.get(cur.index - 1).getInteger();
            } else {
                return cur.list.get(cur.index).getInteger();
            }

        }

        @Override
        public boolean hasNext() {
            //hasNext的功能是判断是否还有整数
            //在次添加上清除空List的功能
            //保证每次弹出来的栈顶元素对应的就是一个整数
            if (stack.isEmpty()) {
                return false;
            }

            while (!stack.isEmpty()) {
                //开始循环清楚空List寻找整数
                //如果找到整数则跳出循环；否则的话循环到空
                CurNestedList cur = stack.pop();
                NestedInteger curNestedInteger = cur.list.get(cur.index);
                if (curNestedInteger.isInteger()) {
                    //是整数
                    stack.push(cur);
                    break;
                } else {
                    //是List
                    if (cur.index + 1 < cur.list.size()) {
                        //把cur层的下一个点记录下来
                        cur.index += 1;
                        stack.push(cur);
                    }
                    List<NestedInteger> list = curNestedInteger.getList();
                    if (list.size() == 0) {
                        continue; //是空List
                    } else {
                        stack.push(new CurNestedList(list, 0));
                    }
                }
            }

            return !stack.isEmpty();

        }

    }
}
