import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = Integer.parseInt(sc.nextLine());
            String[] name = new String[num];
            for (int i=0;i<num;i++) {
                name[i] = sc.nextLine();
            }
            System.out.println(Lname(name));
        }
    }

    private static String Lname(String[] strings){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<strings.length;i++) {
            if (strings[i].contains(",") || strings[i].contains(" ")) {
                stringBuilder.append("\"");
                stringBuilder.append(strings[i]);
                stringBuilder.append("\"");
                if (i != strings.length-1) {
                    stringBuilder.append(", ");
                }
            }else {
                stringBuilder.append(strings[i]);
                if (i != strings.length-1) {
                    stringBuilder.append(", ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
