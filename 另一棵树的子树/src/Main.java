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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q!=null) ||(p!=null && q==null)) return false;
        if(p == null && q==null) return true;
        if(q.val ==p.val) {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null&&s!=null) return false;
        if(s == null) return false;
        if (isSameTree(s,t)) return true;
        return (isSubtree(s.left, t))||(isSubtree(s.right,t));
    }
}
public class Main {
}
