package leetcode.java;

public class PathSum_112 {
  public boolean hasPathSum(TreeNode root, int sum) {
    return pathSum(root, 0, sum);
  }

  public static boolean pathSum(TreeNode root, int tmp, int sum) {
    if (root == null) return false;
    tmp += root.val;
    if (root.left == null && root.right == null) {
      if (tmp == sum) return true;
      else return false;
    }
    if (pathSum(root.left, tmp, sum)) return true;
    return pathSum(root.right, tmp, sum);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
