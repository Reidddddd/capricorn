package leetcode.java;

public class BinaryTreeTilt_563 {
  public int findTilt(TreeNode root) {
    int[] res = new int[1];
    return Math.abs(sufTrav(root.left, res) - sufTrav(root.right, res)) + res[0];
  }

  private int sufTrav(TreeNode node, int[] res) {
    if (node == null) return 0;
    int l = sufTrav(node.left, res);
    int r = sufTrav(node.right, res);
    res[0] += Math.abs(l + r);
    return node.val + l + r;
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
