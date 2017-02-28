package leetcode.java;

public class InvertBinaryTree_226 {
  // always remember check the initial state like empty, none
  // swap is from top to down, then left to right
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    
    TreeNode swap = root.left;
    root.left = root.right;
    root.right = swap;
    invertTree(root.left);
    invertTree(root.right);
    return root;
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
