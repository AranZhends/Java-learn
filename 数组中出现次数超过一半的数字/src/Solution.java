public class Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int cond = -1;
        int cnt = 0;
        for (int i = 0;i<array.length;i++) {
            if (cnt == 0) {
                cond = array[i];
                cnt++;
            }else {
                if (cond == array[i]) {
                    cnt++;
                }else {
                    cnt--;
                }
            }
        }
        cnt = 0;
        for (int i:array) {
            if (i == cond) {
                cnt++;
            }
        }
        if (cnt > array.length/2) {
            return cond;
        }else {
            return 0;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
