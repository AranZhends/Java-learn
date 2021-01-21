import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean containsDuplicate1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        if(list.size()!=nums.length) {
            return true;
        }
        else return false;
    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(solution.containsDuplicate(nums));
    }
}
