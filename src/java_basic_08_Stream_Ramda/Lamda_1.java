package java_basic_08_Stream_Ramda;

import java.util.ArrayList;
import java.util.List;

/*
람다 표현식

람다식은 함수를 하나의 식으로 표현한 것

그런데 자바는 객체지향 언어 : 기능사용 > 클래스 > new > 객체.기능 접근

자바에 람다식 ... 함수형 인터페이스 생성

함수형 인터페이스 > 단 하나의 추상 메서드만 선언된 인터페이스를 ... 익명클래스 방식 .. 줄인다 ... 람다식

interface MyFunc {
int max(int a, int b);
}
강제(함수형 인터페이스) 검사
@FunctionalInterface
interface MyFunc { .. }
 */
@FunctionalInterface
interface MyLamdaFunction {
    int max(int a, int b);
}

public class Lamda_1 {
    public static void main(String[] args) {
        //기존 방식 (익명 클래스)
        System.out.println(new MyLamdaFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        }.max(3,5));

        //익명 클래스를 줄이자 -> 코드를 람다
        //더 줄여보자 ... 람다식
        MyLamdaFunction lamdaFunction = (a,b) -> a > b ? a : b;
        System.out.println(lamdaFunction.max(3,5));

        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("python");
        list.add("c#");

        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("********************************************");
		/*
		list.forEach(System.out::println);  //문법 : 메서드 참조라는 문법 (람다식을 축약하는 문법)
		이것은 forEach(s -> System.out.println(s));을 축약한 형태입니다.

		*/
        list.stream().forEach((String str) -> {System.out.println(str);});
        System.out.println("********************************************");
        list.stream().forEach(str -> {System.out.println(str);});
        System.out.println("********************************************");
        list.stream().forEach(System.out::println);
    }
}
