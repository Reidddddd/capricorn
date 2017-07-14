package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree_637 {
  public List<Double> averageOfLevels(TreeNode root) {
    LinkedList<Double> res = new LinkedList<>();
    if (root == null) return res;

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int levelSize = 0;
    while ((levelSize = queue.size()) > 0) {
      double avg = 0.0;
      int size = 0;
      for (; levelSize > 0; levelSize--) {
        TreeNode node = queue.removeFirst();
        size++;
        avg += (node.val - avg) / size;
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      res.add(avg);
    }
    return res;
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
