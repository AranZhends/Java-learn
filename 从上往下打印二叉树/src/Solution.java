import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if(root.left!=null) {
                queue.offer(root.left);
            }
            if(root.right!=null) {
                queue.offer(root.right);
            }
        }
        return list;
    }
}
