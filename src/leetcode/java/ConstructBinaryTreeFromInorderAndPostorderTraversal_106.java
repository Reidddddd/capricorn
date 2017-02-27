package leetcode.java.medium;

import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
      return null;
    }
    int postPt = postorder.length - 1;
    int inPt = inorder.length - 1;
    TreeNode root = new TreeNode(postorder[postPt]);
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    postPt--;

    TreeNode node;
    while (true) {
      if (inorder[inPt] == stack.peek().val) {
        if (--inPt < 0) break;
        node = stack.pop();
        if (!stack.isEmpty() && stack.peek().val == inorder[inPt]) {
          continue;
        }
        node.left = new TreeNode(postorder[postPt]);
        stack.push(node.left);
      } else {
        node = new TreeNode(postorder[postPt]);
        stack.peek().right = node;
        stack.push(node);
      }
      postPt--;
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
