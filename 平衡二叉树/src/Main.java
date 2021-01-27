class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int MaxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return left>right?left+1:right+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.right) && isBalanced(root.left);
    }
}
public class Main {
}
