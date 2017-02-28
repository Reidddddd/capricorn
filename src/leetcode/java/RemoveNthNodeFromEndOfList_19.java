package leetcode.java;

public class RemoveNthNodeFromEndOfList_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode nth = head;
    int i = 0;
    while (i++ < n)
      fast = fast.next;
    if (fast == null) return head.next;
    while (fast.next != null) {
      fast = fast.next;
      nth = nth.next;
    }
    nth.next = nth.next.next;
    return head;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
