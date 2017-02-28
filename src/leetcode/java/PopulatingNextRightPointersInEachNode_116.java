package leetcode.java;

public class PopulatingNextRightPointersInEachNode_116 {
  public void connect(TreeLinkNode root) {
    if (root == null) return;
    root.next = null;
    nodeConnect(root.left, root.right);
  }

  public static void nodeConnect(TreeLinkNode left, TreeLinkNode right) {
    if (left == null) return;
    left.next = right;
    right.next = null;
    nodeConnect(left.left, left.right);
    nodeConnect(left.right, right.left);
    nodeConnect(right.left, right.right);
  }

  class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
  }
}
