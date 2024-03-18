package problem.tag.design.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 919. Complete Binary Tree Inserter
 * <p></p>
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 * <p></p>
 */
public class CBTInserter {

  private List<TreeNode> levelOrder;
  private TreeNode root;

  public CBTInserter(TreeNode root) {
    this.root = root;
    this.levelOrder = new ArrayList<>();
    levelOrder.add(new TreeNode());

    if (root != null) {
      levelOrder.add(root);
      int i = 1;
      while (true) {
        TreeNode node = levelOrder.get(i);
        if (node.left == null) return;
        levelOrder.add(node.left);
        if (node.right == null) return;
        levelOrder.add(node.right);
        i++;
      }
    }
  }

  public int insert(int val) {
    int index = levelOrder.size() - 1;
    TreeNode parent;
    if (index % 2 == 0) {
      parent = levelOrder.get(index / 2);
      parent.right = new TreeNode(val);
      levelOrder.add(parent.right);
    } else {
      parent = levelOrder.get((index + 1) / 2);
      parent.left = new TreeNode(val);
      levelOrder.add(parent.left);
    }
    return parent.val;
  }

  public TreeNode get_root() {
    return root;
  }

}
