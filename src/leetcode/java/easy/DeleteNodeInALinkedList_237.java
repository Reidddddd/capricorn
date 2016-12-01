package leetcode.java.easy;

public class DeleteNodeInALinkedList_237 {
  public void deleteNode(ListNode node) {
    if (node == null || node.next == null) return;
    node.val = node.next.val;
    node.next = node.next.next;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}