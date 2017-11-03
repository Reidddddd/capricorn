package leetcode.java;

public class LowestCommonAncestorOfABinarySearchTree_235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (p == null && q != null) return q;
    if (p != null && q == null) return p;
    if (p.val < root.val && root.val < q.val || q.val < root.val && root.val < p.val) return root;
    if (p.val == root.val || q.val == root.val) return root;
    if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
    return lowestCommonAncestor(root.right, p, q);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
