

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

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree==null&&rightTree==null) return true;
        if((leftTree==null && rightTree!=null) || (leftTree!=null&&rightTree ==null)) return false;
        if(leftTree.val != rightTree.val) return false;
        return isSymmetricChild(leftTree.right,rightTree.left) && isSymmetricChild(leftTree.left,rightTree.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }
}
public class Main {
}
