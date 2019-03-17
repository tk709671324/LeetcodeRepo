public class Solution_1 {

//    Runtime: 2 ms, faster than 88.32% of Java online submissions for Clone Graph.
//    Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Clone Graph.
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> mapping = new HashMap<>();
        ArrayList<Node> nodes = getAll(node);

        for (Node n : nodes) {
            List<Node> list = new ArrayList<>();
            mapping.put(n, new Node(n.val, list));
        }

        for (Node n : nodes) {
            Node newNode = mapping.get(n);
            for (Node neighbor : n.neighbors) {
                newNode.neighbors.add(mapping.get(neighbor));
            }
        }

        return mapping.get(node);
    }

    private ArrayList<Node> getAll(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node n : cur.neighbors) {
                if (!set.contains(n)) {
                    queue.offer(n);
                    set.add(n);
                }
            }
        }

        return new ArrayList(set);
    }
}
