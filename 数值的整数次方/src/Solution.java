public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0) return 0;
        double res = 1;
        long n;
        if(exponent>0) {
            n = exponent;
        }else if(exponent < 0) {
            base = 1/base;
            n = -exponent;
        }else{
            return 1;
        }
        while(n!=0) {
            if((n&1)==1){
                res *= base;
            }
            base*=base;
            n>>=1;
        }
        return res;
    }
}