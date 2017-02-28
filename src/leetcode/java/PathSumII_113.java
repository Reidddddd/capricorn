package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
  private List<List<Integer>> lists = new ArrayList<>();
  private List<Integer> list = new ArrayList<>();
  private int required;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    required = sum;
    if (root == null) return lists;
    if (root.left == null && root.right == null) {
      if (root.val == required) {
        list.add(root.val);
        lists.add(list);
      }
      return lists;
    }
    list.add(root.val);
    dfs(root.left);
    dfs(root.right);
    return lists;
  }

  private void dfs(TreeNode node) {
    if (node == null) return;
    if (node.left == null && node.right == null) {
      if (caculateLeafSum(node.val) == required) {
        list.add(node.val);
        lists.add(new ArrayList<>(list));
        list.remove(list.size() - 1);
      }
      return;
    }
    list.add(node.val);
    dfs(node.left);
    dfs(node.right);
    list.remove(list.size() - 1);
  }

  private int caculateLeafSum(int val) {
    int sum = val;
    for (int ele : list) sum += ele;
    return sum;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
