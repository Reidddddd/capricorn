package leetcode.java;

public class SubtreeOfAnotherTree_572 {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (isEqual(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean isEqual(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;
    if (s.val != t.val) return false;
    return isEqual(s.left, t.left) && isEqual(s.right, t.right);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
