
class Solution {
    public int removeElement(int []nums,int val) {
        int count = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}

public class RemoveElement {
    public static void main(String[] args) {
        Solution so = new Solution();
        int []nums = {0,1,2,2,3,0,4,2};
        int len = so.removeElement(nums,2);
         for (int i = 0; i < len; i++) {
             System.out.println(nums[i]);
         }

    }
}
