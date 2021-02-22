class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        if (name.length()>typed.length()) {
            return false;
        }
        while(j<typed.length()) {
            if(i<name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }else if(j>0 && typed.charAt(j) == typed.charAt(j-1)) {
                j++;
            }else {
                return false;
            }
        }
        if(i == name.length()){
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName(name, typed));
    }
}
