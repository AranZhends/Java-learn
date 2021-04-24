class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        // write code here
        int length = i-j+1;
        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(m);
        char[] sc = s1.toCharArray();
        int s = 0;
        int lenc = length - s2.length();
        for (int k = s1.length()-i-1;k < s1.length()-j;) {
            if (lenc > 0) {
                for (int x = 0;x<length-s2.length();x++) {
                    sc[k] = '0';
                    k++;
                    lenc--;
                }
            }else {
                sc[k] = s2.charAt(s);
                s++;
                k++;
            }
         }
        return Integer.parseInt(new String(sc),2);
    }
}
public class Main {
    public static void main(String[] args) {
        int n = 4355;
        int m = 4;
        int j = 2;
        int i = 7;
        BinInsert binInsert = new BinInsert();
        System.out.println(binInsert.binInsert(n, m, j, i));

    }
}
