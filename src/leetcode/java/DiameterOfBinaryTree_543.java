public class DiameterOfBinaryTree_543 {
  public int diameterOfBinaryTree(TreeNode root) {
    int[] max = new int[2];
    diameter(root, max);
    return max[0];
  }

  private int diameter(TreeNode node, int[] max) {
    if (node == null) return 0;
    int left = diameter(node.left, max);
    int right = diameter(node.right, max);
    max[0] = Math.max(max[0], left + right);
    max[1] = Math.max(left, right) + 1;
    return max[1];
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
