import java.util.Scanner;

public class Fibon {

    public static  int Fibon(int n) {
        int i = 0;
        int j = 1;
        int x = 0;
        int y = n;
        while(y>2)
        {
            x=j+i;
            i=j;
            j=x;
            y--;
        }
        if(n == 1){
            x = 1;
        }
        else if(n==0) {
            x = 0;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ret = sc.nextInt();
        int fib = Fibon(ret);
        System.out.println(fib);
    }
}
