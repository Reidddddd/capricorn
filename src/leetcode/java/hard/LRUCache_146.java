package leetcode.java.hard;

import java.util.HashMap;

public class LRUCache_146 {
  private HashMap<Integer, Node> cached;
  private Node head;
  private Node tail;
  private int capacity;
  private int curSize;

  public LRUCache_146(int capacity) {
    this.cached = new HashMap<>();
    this.capacity = capacity;
    this.curSize = 0;
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.head.next = tail;
    this.head.prev = null;
    this.tail.prev = head;
    this.tail.next = null;
  }

  public int get(int key) {
    Node node = cached.get(key);
    if (node != null) {
      updateNode(node);
      updateCache(node);
      return node.value;
    }
    return -1;
  }

  public void set(int key, int value) {
    Node node = cached.get(key);
    if (node == null) {
      node = new Node(key, value);
      cached.put(key, node);
      curSize++;
      if (curSize > capacity) {
        curSize = capacity;
        cached.remove(tail.prev.key);
        updateNode(tail.prev);
      }
      updateCache(node);
      return;
    }
    node.value = value;
    updateNode(node);
    updateCache(node);
  }

  private void updateCache(Node node) {
    node.next = head.next;
    node.next.prev = node;
    head.next = node;
    node.prev = head;
  }

  private void updateNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
