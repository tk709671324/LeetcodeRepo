public class Solution_1 {

//    Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
//    Memory Usage: 35.5 MB, less than 7.90% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal == rootVal || qVal == rootVal) {
            return root;
        }
        if ((pVal - rootVal) * (qVal - rootVal) < 0) {
            return root;
        }
        //在root的同一侧
        if (rootVal > pVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
