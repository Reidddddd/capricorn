package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    addToList(root, list);
    return list;
  }

  public static void addToList(TreeNode root, List<Integer> list) {
    if (root == null) return;
    addToList(root.left, list);
    if (root.val != '#') list.add(root.val);
    addToList(root.right, list);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
