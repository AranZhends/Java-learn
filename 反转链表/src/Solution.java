 class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val) {
         this.val = val;
     }
 }
     public class Solution {
         public ListNode ReverseList(ListNode head) {
             if (head == null) return null;

             ListNode pre = null;
             ListNode temp = null;
             while (head != null) {
                 temp = head.next;
                 head.next = pre;
                 pre = head;
                 head = temp;
             }
             return pre;
         }
     }

