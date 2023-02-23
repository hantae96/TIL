import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
       List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));

       //Predicate T->boolean
        // filter() 메서드의 매개변수는 한개, Boolean 타입을 반환하는 람다 표현식 및 Predicate 타입 객체가 전달 되어야함.
       Stream<Integer> filterResult = intList.stream().filter(item -> item%2 ==0);
       filterResult.forEach(System.out::println);

       String[] strArray = {"ABC","BAC","AZ","ABCZ","CC"};
       List<String> strList = new ArrayList<>(Arrays.asList(strArray));

       Stream<String> filterResult2 = strList.stream().filter((item) -> {
//           return item.startsWith("A") && item.endsWith("Z") && item.length() >= 3;
           return item.startsWith("A");
       });
       filterResult2.forEach(System.out::println);

       List<Integer> intStreamToList = intList.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
       intStreamToList.forEach(System.out::println);

    }
}
