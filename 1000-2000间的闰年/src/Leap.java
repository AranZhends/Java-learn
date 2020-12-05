public class Leap {
    public static void main(String[] args) {
        for(int i =1000;i<2001;i++){
            if((i%4==0&&i%100!=100)||i%400==0){
                System.out.println(i);
            }
        }
    }
}
