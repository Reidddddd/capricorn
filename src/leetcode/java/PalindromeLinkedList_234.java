package leetcode.java;

public class PalindromeLinkedList_234 {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    // 1. find the middle pointer
    ListNode mid = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      mid = mid.next;
    }
    // 2. reverse the second half
    ListNode half = reverseList(mid);
    // 3. compare two halves
    while (head != null && half != null) {
      if (head.val != half.val) return false;
      head = head.next;
      half = half.next;
    }
    return true;
  }

  private static ListNode reverseList(ListNode head) {
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
