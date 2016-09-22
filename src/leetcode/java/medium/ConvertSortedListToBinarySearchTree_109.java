package leetcode.java.medium;

public class ConvertSortedListToBinarySearchTree_109 {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    ListNode mid = head;
    ListNode fast = head;
    ListNode beforeMid = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      beforeMid = mid;
      mid = mid.next;
    }
    if (beforeMid != null) beforeMid.next = null;
    TreeNode node = new TreeNode(mid.val);
    node.left = sortedListToBST(head);
    node.right = sortedListToBST(mid.next);
    return node;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
