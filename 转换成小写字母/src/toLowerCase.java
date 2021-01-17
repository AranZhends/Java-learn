import java.util.Scanner;

public class toLowerCase {

    public static String toLowerCase(String str) {
        String str2 = "";
       for(int i = 0;i<str.length();i++) {
           char a = str.charAt(i);
           if(a>=65 && a<=90) {
                a += 32;
           }
           str2 += a;
       }
        return str2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ret = toLowerCase(str);
        System.out.println(ret);
    }
}
