class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) {
            return 0;
        }
        s = s.trim();

        int count = s.lastIndexOf(" ");
        if(count == -1) {
            return s.length();
        }
        return s.length()-count-1;
    }
}
public class LastWord {
    public static void main(String[] args) {
        String s = "Hello world";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(s));
    }
}