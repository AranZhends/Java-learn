import java.util.Scanner;

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}


public class MyLogin {

    public static void main(String[] args) {
        String admin = "Lzkzhends";
        String password = "666666";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String adm = scanner.nextLine();
        System.out.println("请输入密码：");
        String word = scanner.nextLine();
        if(!adm.equals(admin)) {
            try {
                throw new MyException("用户名错误");
            }catch (MyException e) {
                e.printStackTrace();
            }
        }else if(!word.equals(password)) {
            try {
                throw new MyException("密码错误");
            }catch (MyException e) {
                e.printStackTrace();
            }
        }else System.out.println("登陆成功");
    }
}
