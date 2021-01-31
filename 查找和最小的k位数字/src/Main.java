import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        if(k>nums1.length*nums2.length)
        {
            k = nums1.length * nums2.length;
        }

        PriorityQueue<int []> qu = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] + o[1]));
        for(int i = 0;i<nums1.length;i++) {
            for(int j = 0;j< nums2.length;j++) {
                qu.offer(new int[]{nums1[i],nums2[j]});
            }
        }
        List<List<Integer>> lists = new ArrayList<>();

        while(k>0 && qu!=null) {
            List<Integer> list = new ArrayList<>();
            int[] arr = qu.poll();
            list.add(arr[0]);
            list.add(arr[1]);
            lists.add(list);
            k--;
        }
        return lists;
    }
}
public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        int [] nums1 = {1,1,2};
        int [] nums2 = {1,2,3};
        Solution solution = new Solution();
        list = solution.kSmallestPairs(nums1,nums2,10);
        for(int i = 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }



}
