package leetcode.java.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
  private HashMap<UndirectedGraphNode, UndirectedGraphNode> cache = new HashMap<>();

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;
    if (cache.containsKey(node)) return cache.get(node);

    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    cache.put(node, newNode);
    for (UndirectedGraphNode neighbor : node.neighbors) {
      newNode.neighbors.add(cloneGraph(neighbor));
    }
    return newNode;
  }

  class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
      label = x;
      neighbors = new ArrayList<UndirectedGraphNode>();
    }
  }
}
