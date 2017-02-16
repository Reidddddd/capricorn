package leetcode.java.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> results = new LinkedList<>();
    if (root == null) return results;

    List<Integer> level = null;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean flag = true;
    while (!queue.isEmpty()) {
      int num = queue.size();
      level = new LinkedList<>();
      for (int i = 0; i < num; i++) {
        if (queue.peek().left != null) queue.add(queue.peek().left);
        if (queue.peek().right != null) queue.add(queue.peek().right);
        level.add(queue.poll().val);
      }
      if (flag) results.add(level);
      else {
        Collections.reverse(level);
        results.add(level);
      }
      flag = !flag;
    }
    return results;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
