public class NarNum {
    public static void main(String[] args) {

        for(int i =0;i<1000;i++){
            int j =  i/100;
            int m = (i-j*100)/10;
            int n = i%10;
            if(i == j*j*j+m*m*m+n*n*n){
                System.out.println(i);
            }
        }
    }
}
