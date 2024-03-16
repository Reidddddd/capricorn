package problem.tag.design.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 173. Binary Search Tree Iterator
 * <p></p>
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * <p></p>
 */
public class BSTIterator {

  private Iterator<Integer> iterator;

  public BSTIterator(TreeNode root) {
    List<Integer> results = new ArrayList<>();

    inOrderTravel(results, root);

    iterator = results.iterator();
  }

  private void inOrderTravel(List<Integer> results, TreeNode node) {
    if (node == null) {
      return;
    }

    inOrderTravel(results, node.left);
    results.add(node.val);
    inOrderTravel(results, node.right);
  }

  public int next() {
    return iterator.next();
  }

  public boolean hasNext() {
    return iterator.hasNext();
  }

}
