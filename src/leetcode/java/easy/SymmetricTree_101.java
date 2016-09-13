package leetcode.java.easy;

public class SymmetricTree_101 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return symmetric(root.left, root.right);
  }

  public static boolean symmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if ((left != null && right == null) || (left == null && right != null)) {
      return false;
    }
    if (left.val != right.val) return false;
    if (!symmetric(left.left, right.right)) return false;
    return symmetric(left.right, right.left);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
