public class Num9 {
    public static void main(String[] args) {
        int count =0;
        for(int i =1;i<101;i++){
            if(i%10==9){
                count++;
                if((i/10)%10==9){
                    count++;
                }
            }
            else{
                if((i/10)!=0&&(i/10)==9){
                    count++;
                }

            }
        }
        System.out.println("1-100中一共有"+count+"个数字9");
    }
}
