package leetcode.java;

import java.util.LinkedList;

public class BinarySearchTreeIterator_173 {
  private LinkedList<TreeNode> cache;
  
  public BinarySearchTreeIterator_173(TreeNode root) {
    this.cache = new LinkedList<>();
    while (root != null) {
      cache.add(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return cache.size() != 0;
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = cache.removeLast();
    int res = node.val;
    node = node.right;
    while (node != null) {
      cache.add(node);
      node = node.left;
    }
    return res;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
