package problem.tag.design.medium;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 * <p></p>
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * <p></p>
 */
public class FindElements {

  private TreeNode root;
  private Set<Integer> elements = new HashSet<>();

  public FindElements(TreeNode root) {
    this.root = root;

    recoverTree(root, 0);
  }

  private void recoverTree(TreeNode node, int x) {
    if (node == null) {
      return;
    }

    node.val = x;
    elements.add(x);
    recoverTree(node.left, 2 * x + 1);
    recoverTree(node.right, 2 * x + 2);
  }

  public boolean find(int target) {
    return elements.contains(target);
  }

}
