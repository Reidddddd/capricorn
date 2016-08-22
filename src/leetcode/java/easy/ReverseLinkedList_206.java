package leetcode.java.easy;

public class ReverseLinkedList_206 {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    else if (head.next == null) return head;

    ListNode tmp = null;
    ListNode next = head.next;
    head.next = null;
    while (next != null) {
      tmp = next.next;
      next.next = head;
      head = next;
      next = tmp;
    }
    return head;
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
