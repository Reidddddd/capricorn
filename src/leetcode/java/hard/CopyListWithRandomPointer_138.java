package leetcode.java.hard;

import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
  public RandomListNode copyRandomList(RandomListNode head) {
    HashMap<RandomListNode, RandomListNode> table = new HashMap<>();
    RandomListNode node = head;
    while (node != null) {
      table.put(node, new RandomListNode(node.label));
      node = node.next;
    }
    node = head;
    while (node != null) {
      table.get(node).next = table.get(node.next);
      table.get(node).random = table.get(node.random);
      node = node.next;
    }
    return table.get(head);
  }

  class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  }
}
