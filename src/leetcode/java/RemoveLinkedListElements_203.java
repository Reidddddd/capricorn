package leetcode.java;

public class RemoveLinkedListElements_203 {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
  }

  private ListNode nextNode(ListNode node, int val) {
    if (node == null) return null;
    node.next = nextNode(node.next, val);
    if (node.val == val) return node.next;
    return node;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
