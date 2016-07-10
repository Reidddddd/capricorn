package leetcode.java.two_pointers;

public class LinkedListCycleII_142 {

  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    boolean isCycle = false;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        isCycle = true;
        break;
      }
    }
    if (!isCycle) return null;
    ListNode start = head;
    while (start != slow) {
      start = start.next;
      slow = slow.next;
    }
    return start;
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
