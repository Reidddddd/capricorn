package leetcode.java;

public class AddTwoNumbers_2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = l2;
    int plus = 0;
    int val = 0;
    while (l1 != null && l2 != null) {
      val = l1.val + l2.val + plus;
      l2.val = val % 10;
      plus = val / 10;
      if (l1.next == null || l2.next == null) break;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1.next != null) {
      l1 = l1.next;
      val = l1.val + plus;
      plus = val / 10; 
      l2.next = new ListNode(val % 10);
      l2 = l2.next;
    }
    while (l2.next != null) {
      l2 = l2.next;
      val = l2.val + plus;
      plus = val / 10;
      l2.val = val % 10;
    }
    if (plus > 0) l2.next = new ListNode(1);
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
