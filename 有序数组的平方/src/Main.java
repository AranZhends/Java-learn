import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] nums2 = new int[nums.length];
        for(int i = 0;i<nums.length;i++) {
            nums2[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums2);
        return nums2;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums = {-4,-1,0,3,10};
        int []numsSort = solution.sortedSquares(nums);
        for(int i:numsSort) {
            System.out.println(i);
        }
    }
}
