import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        int count = 0;
        while(count<3){
            count++;
            System.out.print("请输入你的账号：");
            Scanner sc = new Scanner(System.in);
            String user = sc.nextLine();
            System.out.print("请输入你的密码：");
            Scanner ss = new Scanner(System.in);
            String password = ss.nextLine();
            if(user.equals("Lizekang")) {
                if (password.equals("123123")) {
                    System.out.println("登陆成功！");
                    break;
                } else {
                    System.out.println("密码错误！请重新输入");
                }
            }else {
                System.out.println("账号错误！请重新输入！");
            }
        }
        if(count >2) {
            System.out.println("输入错误超过三次，退出");
        }
    }

}
