package quiz;

public class Quiz13 {
    public static void main(String[] args) {
        int totalRice = 102000;
        int eatRice = 20;
        int mouse = 2;
        int day = 0;

        while(totalRice > 0){
            totalRice = totalRice - (mouse)*eatRice;
            day++;
            if (day%10 == 0) mouse = mouse*2;
        }

        System.out.println(day + "일 만에 다먹음");
        System.out.println(mouse + "마리임");

        System.out.println();

        int sum = 0;
        int beforeA = 1;
        int beforeB = 2;
        int count = 0;

        while(sum < 100) {
            if (count % 2 == 0) {
                sum += beforeA * beforeB;
            }else{
                sum -= beforeA * beforeB;
            }
            beforeA++;
            beforeB++;
            count++;
        }

        System.out.println(sum);
        System.out.printf(beforeA+"\t");
        System.out.println(beforeB);
    }
}
