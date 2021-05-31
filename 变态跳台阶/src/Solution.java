public class Solution {
    public int jumpFloorII(int target) {
        if(target <= 0) return 0;
        return 1<<(target-1);
    }
}