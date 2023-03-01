package javaExample;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


@FunctionalInterface
interface Math{
    public int Calc(int first,int second);
}

class Solution {
//    public int solution(int n){
//        return IntStream.rangeClosed(0,n)
//    }
}


public class StreamTest {
    public static void main(String[] args) {
//        String[] fruit = new String[]{"사과","배","포도"};
//        Stream<String> fruitStream = Arrays.stream(fruit);
//        // range 범위 지정 가능
//        Stream<String> partOfFruitStream = Arrays.stream(fruit, 1, 3);
//
//        List<String> carList = Arrays.asList("테슬라", "포르쉐", "현대");
//        Stream<String> carStream = carList.stream();
//        Stream<String> stringStream = carList.parallelStream();
//
//        Stream<String> builderStream = Stream.<String>builder().add("직접").add("하나씩").add("원하는 값 넣을 수 있다.").build();
//
//
//        Stream<String> generate = Stream.generate(() -> "gen");
//        generate.limit(5).forEach(s-> System.out.println(s));
//
//        Stream.iterate(30,n -> n+2).limit(5).forEach(s -> System.out.println(s));
//
//
//        IntStream intStream = IntStream.range(1,5);
//        LongStream longStream = LongStream.rangeClosed(1,5);

//        IntStream charStream = "Stream".chars();
//        charStream.forEach(i-> System.out.println(i));
//
//        Stream<String> stringStream = Pattern.compile(",").splitAsStream("test1,test2,test3");
//        stringStream.forEach(i -> System.out.println(i));

//        List<String> names = Arrays.asList("Eric", "Elena", "Java");
//        names.stream().filter(name -> name.contains("a")).forEach(i-> System.out.println(i));
//
//        int sum = IntStream.of(1,3,5,7,9).peek(System.out::println).sum();
//
//        long count = IntStream.of(1,2,3,7,9).count();

        IntStream.of(2,3,5,1).forEach(i -> System.out.println(i));

        OptionalInt min = IntStream.of(1,3,5,7,9).min();
    }
}
