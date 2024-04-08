package problem.tag.design.medium;

import java.util.ArrayList;

/**
 * 1993. Operations on Tree
 * <p></p>
 * https://leetcode.com/problems/operations-on-tree/
 * <p></p>
 */
public class LockingTree {

  private NodeWithLock[] nodes;

  public LockingTree(int[] parent) {
    nodes = new NodeWithLock[parent.length];
    nodes[0] = new NodeWithLock();

    for (int i = 1; i < parent.length; i++) {
      if (nodes[i] == null) {
        nodes[i] = new NodeWithLock();
      }

      int parentIndex = parent[i];
      if (nodes[parentIndex] == null) {
        nodes[parentIndex] = new NodeWithLock();
      }

      nodes[i].link(parentIndex, nodes[parentIndex]);
    }
  }

  public boolean lock(int num, int user) {
    return nodes[num].lock(user);
  }

  public boolean unlock(int num, int user) {
    return nodes[num].unlock(user);
  }

  public boolean upgrade(int num, int user) {
    NodeWithLock node = nodes[num];
    // 1. The node is unlocked
    // 2. It has at least one locked descendant (by any user)
    if (node.isLocked() ||
        !findChildrenWithLock(node)) {
      return false;
    }
    // 3. It does not have any ålocked ancestors
    while (node.parent != -1) {
      node = nodes[node.parent];
      if (node.isLocked()) {
        return false;
      }
    }

    node = nodes[num];
    unlockAllDescendant(node);
    return node.lock(user);
  }

  /**
   * @return true if any children with lock
   */
  boolean findChildrenWithLock(NodeWithLock node) {
    if (node.isLocked()) {
      return true;
    }

    if (node.children.isEmpty()) {
      return false;
    }

    for (NodeWithLock child : node.children) {
      if (findChildrenWithLock(child)) {
        return true;
      }
    }
    return false;
  }

  void unlockAllDescendant(NodeWithLock node) {
    if (node.isLocked()) {
      node.unlock(-1, true);
    }

    if (node.children.isEmpty()) {
      return;
    }

    for (NodeWithLock child : node.children) {
      unlockAllDescendant(child);
    }
  }

  enum LockState { LOCK, UNLOCK }

  class NodeWithLock {
    LockState state = LockState.UNLOCK;
    ArrayList<NodeWithLock> children;
    int userWithLock;
    int parent;

    NodeWithLock() {
      children = new ArrayList<>();
      parent = -1;
    }

    boolean isLocked() {
      return state == LockState.LOCK;
    }

    boolean lock(int user) {
      if (state == LockState.LOCK) {
        return false;
      }

      userWithLock = user;
      state = LockState.LOCK;
      return true;
    }

    boolean unlock(int user) {
      return unlock(user, false);
    }

    boolean unlock(int user, boolean force) {
      if (force) {
        userWithLock = -1;
        state = LockState.UNLOCK;
        return true;
      }

      if (user != userWithLock ||
          state == LockState.UNLOCK) {
        return false;
      }

      userWithLock = -1;
      state = LockState.UNLOCK;
      return true;
    }

    void link(int parent, NodeWithLock parentNode) {
      this.parent = parent;
      parentNode.children.add(NodeWithLock.this);
    }
  }

}
