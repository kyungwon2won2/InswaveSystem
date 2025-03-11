package java_basic_08_Stream_Ramda;

/*
		 2. Stream 가공하기(중간연산)
			생성한 Stream 객체에서 요소들을 가공하기 위해서는 중간연산이 필요하다.
			가공하기 단계의 파라미터로는 앞서 설명하였던 함수형 인터페이스들이 사용되며,
			여러 개의 중간연산이 연결되도록 반환값으로 Stream을 반환한다.


			[ 필터링 - Filter ]

			Filter는 Stream에서 조건에 맞는 데이터만을 정제하여 더 작은 컬렉션을 만들어내는 연산이다.
			Java에서는 filter 함수의 인자로 함수형 인터페이스 Predicate를 받고 있기 때문에,
			boolean을 반환하는 람다식을 작성하여 filter 함수를 구현할 수 있다.
			예를 들어 어떤 String의 stream에서 a가 들어간 문자열만을 포함하도록 필터링하는
			예제는 다음과 같이 작성할 수 있다.

 */


import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
public class Stream_3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "aa", "aaa", "bb");

        Stream<String> stream = list.stream().filter(name -> name.contains("a"));
        stream.forEach(System.out :: println);
    /*
	[ 데이터 변환 - Map ]
	Map은 기존의 Stream 요소들을 변환하여 새로운 Stream을 형성하는 연산이다.
	저장된 값을 특정한 형태로 변환하는데 주로 사용되며,
	Java에서는 map 함수의 인자로 함수형 인터페이스 function을 받고 있다. 예를 들어

	위의 map 함수의 람다식은 메소드 참조를 이용해 변경이 가능하다.
 	이번에는 메소드 참조를 이용하여 파일의 Stream을 파일 이름의 Stream으로 변경해보자.
    */
        List<String> names = Arrays.asList("a", "b", "c", "aa", "aaa", "bb");
        Stream<String> stream2 = names.stream().map(s -> s.toUpperCase());
//        stream2.forEach(data -> System.out.println(data));
        stream2.forEach(System.out :: println); //위에꺼라 같은거.

        //메서드 참조
        //파일 클래스..
        Stream<File> fileStream = Stream.of(new File("Test1.java"), new File("Test2.java"), new File("Test3.java"));
        //file 객체에서 파일명만 출력
        Stream<String> fileNameStream = fileStream.map(File :: getName);//file 객체 안에 있는 getName 함수 참조
        fileNameStream.forEach(System.out :: println);

        /*
        [ 정렬 - Sorted ]
        Stream의 요소들을 정렬하기 위해서는 sorted를 사용해야하며, 파라미터로 Comparator를 넘길 수도 있다.
        Comparator 인자 없이 호출할 경우에는 오름차순으로 정렬이 되며, 내림차순으로 정렬하기 위해서는
        Comparator의 reveseOrder를 이용하면 된다.
        예를 들면 어떤 Stream의 String 요소들을 정렬하기 위해서는 다음과 같이 sorted를 활용할 수 잇다.

        select empno, ename from emp order by sal desc
        select empno, ename from emp order by sal asc
         */
        System.out.println("-----------------------------------------------------------------------");

        List<String> list3 = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

        Stream<String> stream3 = list3.stream().sorted();

        stream3.forEach(System.out :: println);
        //Go Groovy Java Python Scala Swift
        System.out.println("-----------------------------------------------------------------------");

        Stream<String> stream4 = list3.stream().sorted(Comparator.reverseOrder());
        stream4.forEach(System.out::println);
        //Swift Scala Python Java Groovy Go
    }

}
