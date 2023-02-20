package quiz;

public class Quiz10 {
    public static void main(String[] args) {
        for(int i = 1;i<6;i++){
            for(int j = i;j<=i*5;j=j+i){
                System.out.print(j+"\t");
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 1; i<25;i =i+5){
            for(int j = i;j<=i+4;j++){
                System.out.print(j+"\t");
            }
            System.out.println();
        }

    }
}
