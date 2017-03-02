package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<Integer>();
    addToList(root, list);
    return list;
  }

  public static void addToList(TreeNode root, List<Integer> list) {
    if (root == null) return;
    if (root.val != '#') list.add(root.val);
    addToList(root.left, list);
    addToList(root.right, list);
  }
}
