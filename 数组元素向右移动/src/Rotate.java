import java.util.Arrays;

public class Rotate {
    public static void rotate(int[] nums, int k) {
        int []arr = new int[nums.length];
        for(int i = 0;i<nums.length;i++) {
            arr[i] = nums[i];
        }
        for(int i =0;i<nums.length;i++) {
           nums[(i+k)%nums.length] = arr[i];
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
//[1,2,3,4,5,6,7]
//[7,1,2,3,4,5,6]