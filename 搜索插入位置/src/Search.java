class Solution {
    public int searchInsert(int[] nums, int target) {

        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        if(nums[0]>target) {
            return 0;
        }
        if(nums[nums.length-1]<target) {
            return nums.length;
        }
        for(int i = 0;i<nums.length;i++) {
            if(nums[i]<target && nums[i+1]>target) {
                return i+1;
            }
        }
        return -1;
    }
}


public class Search {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {1,3,5,6};
        int tar = so.searchInsert(nums,0);
        System.out.println(tar);
    }
}
