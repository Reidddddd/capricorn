package leetcode.java.two_pointers;

public class PartitionList_86 {
  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode sHead = new ListNode(-1);
    ListNode bHead = new ListNode(-1);
    ListNode smaller = sHead;
    ListNode bigger = bHead;
    while (head != null) {
      if (head.val >= x) {
        bigger.next = head;
        bigger = bigger.next;
      } else {
        smaller.next = head;
        smaller = smaller.next;
      }
      head = head.next;
    }
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
