package leetcode.java.two_pointers;

public class RemoveNthNodeFromEndOfList_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode nth = head;
    int i = 1;
    while (i++ < n) fast = fast.next;

    ListNode parent = null;
    while (fast.next != null) {
      fast = fast.next;
      parent = nth;
      nth = nth.next;
    }

    parent.next = nth.next;
    return head;
  }

  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }
}
