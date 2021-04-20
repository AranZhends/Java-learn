import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        int num = list.get(list.size()-1);
        list.remove(list.size()-1);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int count = 0;
        for (int i =0;i < num;i++) {
            if(count != num-1) {
                count++;
                System.out.print(list.get(i) + " ");
            }else {
                System.out.print(list.get(i));
            }

        }
    }
}
