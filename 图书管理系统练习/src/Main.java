import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {

    public static User Login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名：");
        String name = sc.nextLine();
        System.out.println("请输入你的身份：1-》管理员 0：普通用户");
        int choice = sc.nextInt();
        if(choice == 1) {
            return new AdminUser(name);
        }else  {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
            BookList bookList = new BookList();
            User user = Login();
            while (true) {
                int choice = user.menu();
                user.doOperation(choice,bookList);
            }
        }

}