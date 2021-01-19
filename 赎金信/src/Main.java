import java.util.Arrays;

class  Solution {
    public  boolean canConstruct(String ransomNote, String magazine) {

        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        if(ransomNote.length()==magazine.length()) {
            Arrays.sort(ransom);
            Arrays.sort(maga);
            if(String.valueOf(ransom).equals(String.valueOf(maga))) {
                return true;
            }
            else
                return false;
        }
        int i = 0;
        int j = 0;

        if(ransom.length>maga.length) {
            return false;
        }
        while(i<ransom.length && j<maga.length) {
            Arrays.sort(ransom);
            Arrays.sort(maga);
            for (j = 0; j < maga.length; j++) {
                if (ransom[i] == maga[j]) {
                    i++;
                    if(i>=ransom.length && j<maga.length) {
                        return true;
                    }
                }
            }
        }
            if(i>=ransom.length) {
                return true;
            }else{
                return false;
            }
        }
    }


public class Main {
    public static void main(String[] args) {
        String str1 = "fihjjjjei";
        String str2 = "hjibagacbhadfaefdjaeaebgi";
        Solution s = new Solution();
        System.out.println(s.canConstruct(str1, str2));
    }
}