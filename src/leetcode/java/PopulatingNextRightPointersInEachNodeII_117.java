package leetcode.java.hard;

public class PopulatingNextRightPointersInEachNodeII_117 {
  public void connect(TreeLinkNode root) {
    if (root == null) return;

    TreeLinkNode leftMost = root;
    TreeLinkNode parent = null;
    while (leftMost != null) {
      parent = leftMost;
      leftMost = null;
      while (parent != null) {
        if (parent.left != null) {
          parent.left.next = (parent.right != null) ? parent.right : getNext(parent);
          if (leftMost == null) leftMost = parent.left;
        }
        if (parent.right != null) {
          parent.right.next = getNext(parent);
          if (leftMost == null) leftMost = parent.right;
        }
        parent = parent.next;
      }
    }
  }

  private TreeLinkNode getNext(TreeLinkNode parent) {
    TreeLinkNode node = parent.next;
    while (node != null) {
      if (node.left != null) return node.left;
      if (node.right != null) return node.right;
      node = node.next;
    }
    return null;
  }

  class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
  }
}
