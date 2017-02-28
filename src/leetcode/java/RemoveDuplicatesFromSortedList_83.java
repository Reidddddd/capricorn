package leetcode.java;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList_83 {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    Set<Integer> dup = new HashSet<>();
    ListNode pre = head, nxt = head;
    while (nxt != null) {
      if (dup.add(nxt.val)) {
        pre = nxt;
      } else {
        pre.next = nxt.next;
      }
      nxt = nxt.next;
    }
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
