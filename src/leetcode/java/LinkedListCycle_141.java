package leetcode.java;

public class LinkedListCycle_141 {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slow = head;
    while (head != null && head.next != null) {
      head = head.next.next;
      slow = slow.next;
      if (head == slow) return true;
    }
    return false;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
