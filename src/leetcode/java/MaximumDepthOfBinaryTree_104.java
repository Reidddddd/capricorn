package leetcode.java;

public class MaximumDepthOfBinaryTree_104 {
  // 1. if root == null, return 0;
  // 2. else call maxDepth recursive.
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
