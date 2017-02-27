package leetcode.java.easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) return result;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int size = 0;
    TreeNode node = null;
    while ((size = queue.size()) != 0) {
      LinkedList<Integer> level = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        node = queue.removeFirst();
        level.add(node.val);
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      ((LinkedList) result).addLast(level);
    }
    return result;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
