import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if( root != null) {
            list.add(root.val);
            List<Integer> listleft = preorderTraversal(root.left);
            list.addAll(listleft);
            List<Integer> listright = preorderTraversal(root.right);
            list.addAll(listright);
        }
        return list;
    }

}
public class Main {
}
