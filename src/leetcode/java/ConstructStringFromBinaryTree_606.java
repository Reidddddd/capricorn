package leetcode.java;

public class ConstructStringFromBinaryTree_606 {
  public String tree2str(TreeNode t) {
    if (t == null) return "";
    StringBuilder b = new StringBuilder();
    appendNode(t, b);
    return b.toString();
  }

  private void appendNode(TreeNode t, StringBuilder b) {
    b.append(t.val);
    if (t.left != null) preTrav(t.left, b);
    if (t.right != null) {
      if (t.left == null) {
        b.append("()");
      }
      preTrav(t.right, b);
    }
  }

  private void preTrav(TreeNode t, StringBuilder b) {
    b.append("(");
    appendNode(t, b);
    b.append(")");
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
