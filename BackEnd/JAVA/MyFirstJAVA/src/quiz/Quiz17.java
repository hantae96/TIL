package quiz;

import java.util.Arrays;
public class Quiz17 {
    public static void main(String[] args) {
        String check = "FF590-2DX83-M81LZ-XDM7E-MKUT4";
        String[] splitCheck =check.split("-");
        int sum = 0;

        for (String elem : splitCheck) sum += Integer.valueOf(elem.replaceAll("[^0-9]", ""));
        System.out.println(sum);
    }
}
