import java.util.*;


 class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }


public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null) return null;
        ListNode fast = pHead;
        for(int i = 0;i<k;i++) {
            if(fast == null) return null;
            fast = fast.next;
        }
        ListNode slow = pHead;
        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}