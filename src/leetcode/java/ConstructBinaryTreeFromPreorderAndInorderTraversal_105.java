package leetcode.java;

import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
      return null;
    }
    int prePt = 0;
    int inPt = 0;
    TreeNode root = new TreeNode(preorder[prePt++]);
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    TreeNode node;
    while (true) {
      if (inorder[inPt] == stack.peek().val) {
        if (++inPt > inorder.length - 1) break;
        node = stack.pop();
        if (!stack.isEmpty() && stack.peek().val == inorder[inPt]) {
          continue;
        }
        node.right = new TreeNode(preorder[prePt]);
        stack.push(node.right);
      } else {
        node = new TreeNode(preorder[prePt]);
        stack.peek().left = node;
        stack.push(node);
      }
      prePt++;
    }
    return root;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
