package leetcode.java.hard;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> postOrder = new LinkedList<Integer>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.addFirst(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.removeLast();
      if (node != null) {
        postOrder.addFirst(node.val);
        stack.addLast(node.left);
        stack.addLast(node.right);
      }
    }
    return postOrder;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
