package leetcode.java;

public class SerializeAndDeserializeBinaryTree_297 {
  private static final String NULL = "$";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    serialize(root, builder);
    return builder.toString();
  }

  private void serialize(TreeNode root, StringBuilder builder) {
    if (root == null) {
      builder.append(NULL + ",");
      return;
    }
    builder.append(root.val + ",");
    serialize(root.left, builder);
    serialize(root.right, builder);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] dchar = data.split(",");
    return deserialize(dchar, new Index(0));
  }

  private TreeNode deserialize(String[] data, Index i) {
    if (i.index >= data.length || i.index < data.length && data[i.index].equals(NULL)) return null;
    TreeNode node = new TreeNode(Integer.valueOf(data[i.index]));
    i.index++;
    node.left = deserialize(data, i);
    i.index++;
    node.right = deserialize(data, i);
    return node;
  }

  class Index {
    int index;
    public Index(int i) { this.index = i; }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
