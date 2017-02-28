package leetcode.java;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
  private List<Integer> list;
  private int depth;
  private int maxDepth;

  public List<Integer> rightSideView(TreeNode root) {
    list = new LinkedList<>();
    maxDepth = depth = 0;
    if (root == null) return list;
    list.add(depth, root.val);
    dfs(root.left);
    dfs(root.right);
    return list;
  }

  private void dfs(TreeNode node) {
    if (node == null) return;
    depth++;
    if (maxDepth < depth) {
      maxDepth = depth;
      list.add(depth, node.val);
    } else {
      list.set(depth, node.val);
    }
    dfs(node.left);
    dfs(node.right);
    depth--;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
