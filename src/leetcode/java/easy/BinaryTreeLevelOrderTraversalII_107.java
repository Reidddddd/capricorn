package leetcode.java.easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII_107 {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    if (root == null) return result;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    TreeNode node = null;
    int size = 0;
    while ((size = queue.size()) != 0) {
      LinkedList<Integer> level = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        node = queue.removeFirst();
        level.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      ((LinkedList) result).addFirst(level);
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