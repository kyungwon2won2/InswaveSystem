package java_basic_08_Stream_Ramda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift", "Java");

        //중복제거해서 출력
        list.stream()
                .distinct()
                .forEach(System.out::println);

        int sum = IntStream.of(1,3,5,7,9)
                                .peek(System.out::println) //Stream 에 영향을 주지않고 그냥 확인하는 작업
                                .sum();
        System.out.println("sum : " + sum);
    }
}
