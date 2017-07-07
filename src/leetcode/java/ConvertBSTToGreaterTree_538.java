package leetcode.java;

public class ConvertBSTToGreaterTree_538 {
  public TreeNode convertBST(TreeNode root) {
    if (root == null) return null;
    int[] res = new int[1];
    bstTrav(root, res);
    return root;
  }

  private void bstTrav(TreeNode node, int[] res) {
    if (node == null) return;
    bstTrav(node.right, res);
    int tmp = node.val;
    node.val += res[0];
    res[0] += tmp;
    bstTrav(node.left, res);
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
