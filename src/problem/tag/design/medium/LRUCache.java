package problem.tag.design.medium;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * <p></p>
 * https://leetcode.com/problems/lru-cache/
 * <p></p>
 */
public class LRUCache {

  private HashMap<Integer, Node> key2Node;
  private Node head;
  private Node tail;
  private int capacity;
  private int size;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    size = 0;
    key2Node = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
  }

  public int get(int key) {
    if (!key2Node.containsKey(key)) {
      return -1;
    }

    Node node = key2Node.get(key);
    updateNode(node);
    updateTail(node);
    return node.val;
  }

  public void put(int key, int value) {
    Node newNode = new Node(key, value);
    Node oldNode = key2Node.putIfAbsent(key, newNode);
    if (oldNode != null) {
      oldNode.val = value;
      updateNode(oldNode);
      updateTail(oldNode);
      return;
    }

    if (size < capacity) {
      size++;
      if (head.next == null) {
        head.next = newNode;
        tail.prev = newNode;
        newNode.prev = head;
        newNode.next = tail;
      } else {
        updateTail(newNode);
      }
      return;
    }

    Node remove = head.next;
    head.next = remove.next;
    remove.next.prev = head;

    updateTail(newNode);

    key2Node.remove(remove.key);
    remove.next = null;
    remove.prev = null;
  }

  private void updateNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void updateTail(Node node) {
    tail.prev.next = node;
    node.prev = tail.prev;
    tail.prev = node;
    node.next = tail;
  }

  class Node {
    Node prev;
    Node next;
    int key;
    int val;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

}
