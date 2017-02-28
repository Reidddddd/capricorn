package leetcode.java;

public class RotateList_61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return null;
    else if (k == 0) return head;
    ListNode slow, fast, size;
    size = slow = fast = head;
    // 1. Count the size of list
    int len = 0;
    while (size != null) {
      len++;
      size = size.next;
    }
    // 2. Count the exact kth
    k = k % len;
    while (k-- > 0) fast = fast.next;
    // 3. Rotate list
    if (fast == slow) return head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    fast.next = head;
    head = slow.next;
    slow.next = null;
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
