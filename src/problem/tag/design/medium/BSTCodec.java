package problem.tag.design.medium;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 449. Serialize and Deserialize BST
 * <p></p>
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 * <p></p>
 */
public class BSTCodec {

  public String serialize(TreeNode root) {
    StringBuilder b = new StringBuilder();
    encode(root, 1, b);
    return b.toString();
  }

  private void encode(TreeNode node, int index, StringBuilder b) {
    if (node == null) {
      return;
    }
    b.append(index + ";");
    b.append(node.val);
    b.append(";");
    encode(node.left, index * 2, b);
    encode(node.right, index * 2 + 1, b);
  }

  public TreeNode deserialize(String data) {
    if (data.equals("")) return null;

    String[] nodes = data.split(";");
    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    for (int i = 0; i < nodes.length; i += 2) {
      nodeMap.put(Integer.parseInt(nodes[i]), new TreeNode(Integer.parseInt(nodes[i + 1])));
    }

    for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
      int index = entry.getKey();
      if (index == 1) continue;

      TreeNode node = entry.getValue();
      if (index % 2 == 0) {
        nodeMap.get(index / 2).left = node;
      } else {
        nodeMap.get((index - 1) / 2).right = node;
      }
    }
    return nodeMap.get(1);
  }

}
