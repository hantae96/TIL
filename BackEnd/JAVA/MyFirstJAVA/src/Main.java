import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.awt.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList list1 = new ArrayList(10);

        list1.add(new Integer(5));
        list1.add(4);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(3);

        ArrayList list2 = new ArrayList(list1.subList(1, 4));

        Collections.sort(list1);
        Collections.sort(list2);
//        print(list1);
//        print(list2);

//        System.out.println(list1.containsAll(list2));
        print(list1);
        list1.add(0,"1");
        print(list1);
        list1.remove(new Integer(1));
        print(list1);
    }

    static void print(ArrayList list){
        for (int i = 0; i<list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}