import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

public class Main {
    boolean isCompleteTree(TreeNode root) {
        if(root == null) return  true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = new TreeNode();
        while(queue.peek()!=null) {
            cur = queue.poll();
            if(cur!=null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        for (TreeNode i:queue) {
            if(i!=null) return false;
        }
        return true;
    }


}
