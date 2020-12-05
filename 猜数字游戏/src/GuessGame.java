import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void meun() {
        System.out.println("**********");
        System.out.println("**1.play**");
        System.out.println("**0.exit**");
        System.out.println("**********");
    }

    public static void game(int i){

        while(true){
            System.out.println("请输入你猜的(1-10)数字：");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(input == i) {
                System.out.println("猜对了！");
                break;
            }else if(input > i){
                System.out.println("猜大了！");
            }else {
                System.out.println("猜小了！");
            }
        }

    }
    public static void main(String[] args) {
        
        do{
            Random random = new Random();
            int i = random.nextInt(10);
            meun();
            System.out.print("请选择是否进入游戏：");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input){
                case 0:
                    break;
                case 1:
                    game(i);
                default:
                    break;
            }

        }while(true);
    }

}
