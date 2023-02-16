package javaExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@FunctionalInterface
interface Math{
    public int Calc(int first,int second);
}


public class StreamTest {
    public static void main(String[] args) {
        String[] arr = new String[]{"가","나","다"};
//        Stream<String> stream = Arrays.stream(arr,1,3);

        List<String> list = Arrays.asList("a","b","c");
        // 간편하게 자료구조.stream() 메소드를 통해서 stream 객체로 변환
        Stream<String> stream = list.stream();

        Stream<String> builerStream = Stream.<String> builder().add("Eric").add("Elena").add("Java").build();

        // Supplier -> 입력값은 없고 리턴값만 있는 함수형 인터페이스
        Stream<String> generatedStream = Stream.generate(()->"gen").limit(5);

        Stream<Integer> iteratedStream = Stream.iterate(30,n->n+2).limit(5);

        List<String> names = Arrays.asList("한태","소현","가영");
        // 스트림은 일회용이다.
        Stream<String> stream2 = names.stream().filter(name -> name.contains("태"));

        Stream<String> stream3 = names.stream().map(String::toUpperCase);
    }
}
