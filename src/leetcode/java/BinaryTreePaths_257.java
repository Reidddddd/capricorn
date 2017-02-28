package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
  private List<String> result = new ArrayList<>();
  private List<Integer> list = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return result;
    dfs(root);
    return result;
  }

  private void dfs(TreeNode node) {
    if (node == null) return;
    list.add(node.val);
    if (node.left == null && node.right == null) {
      result.add(convertToString(list));
      list.remove(list.size() - 1);
      return;
    }
    dfs(node.left);
    dfs(node.right);
    list.remove(list.size() - 1);
  }

  private String convertToString(List<Integer> root2Leaf) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < root2Leaf.size(); i++) {
      if (i == root2Leaf.size() - 1) builder.append(root2Leaf.get(i));
      else builder.append(root2Leaf.get(i)).append("->");
    }
    return builder.toString();
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
