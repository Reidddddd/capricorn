package leetcode.java;

public class RecoverBinarySearchTree_99 {
  private TreeNode first, second, temp;

  public void recoverTree(TreeNode root) {
    first = null;
    second = null;
    temp = new TreeNode(Integer.MIN_VALUE);
    travel(root);
    int tmp = second.val;
    second.val = first.val;
    first.val = tmp;
    return;
  }

  private void travel(TreeNode node) {
    if (node == null) return;
    travel(node.left);
    if (first == null && temp.val >= node.val) first = temp;
    if (first != null && temp.val >= node.val) second = node;
    temp = node;
    travel(node.right);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
