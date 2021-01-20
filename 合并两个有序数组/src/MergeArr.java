import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = 0;i<n;i++) {
            nums1[m] = nums2[i];
            m++;
        }
        Arrays.sort(nums1);
    }
}

public class MergeArr {
    public static void main(String[] args) {
        int []nums1 = {1,2,3,0,0,0};
        int []nums2 = {2,5,6};
        int m = nums1.length-nums2.length;
        int n = nums2.length;
        Solution solution = new Solution();
        solution.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
