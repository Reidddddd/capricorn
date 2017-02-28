package leetcode.java;

public class SwapNodesInPairs_24 {
  public ListNode swapPairs(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    head.next.next = swapPairs(head.next.next);
    ListNode h = head.next;
    head.next = h.next;
    h.next = head;
    return h;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}