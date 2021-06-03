import java.util.*;

public class Solution {
    public int[] reOrderArray (int[] array) {
        // write code here
        int[] res = new int[array.length];
        int index = 0;
        for(int i:array) {
            if((i&1) == 1) {
                res[index] = i;
                index++;
            }
        }
        for(int i:array) {
            if((i&1) == 0) {
                res[index] = i;
                index ++;
            }
        }
        return res;
    }
}
