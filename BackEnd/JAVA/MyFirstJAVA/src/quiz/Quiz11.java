package quiz;

public class Quiz11 {
    public static void main(String[] args) {
        int num = 100;

        for(int i = 2;i<(num+1);i++){
            boolean flag = true;
            for(int j = 2;j<i;j++){
                if(i%j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println(i);
        }

        for(int x = 0;x<10;x++){
            for(int y = 0;y<10;y++){
                if(3*x + 2*y == 10){
                    System.out.println(x + " " + y);
                }
            }
        }
    }


}
