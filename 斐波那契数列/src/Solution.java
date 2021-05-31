public class Solution {
    public int Fibonacci(int n) {
        if(n==0) return 0;
        int s = 0;
        int m = 1;
        int result = m+s;
        for(int i = 2;i<=n;i++) {
            result = s + m;
            s = m;
            m = result;
        }
        return result;
    }
}
