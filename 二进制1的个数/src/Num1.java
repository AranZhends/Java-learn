import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        System.out.print("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        int sum =0;
        while(num/2 != 0){
            if(num % 2 ==1){
                count++;
            }
            num = num / 2;
        }
        if(num == 1){
            count++;
        }
        System.out.println("二进制中1的个数："+count);
    }
}
