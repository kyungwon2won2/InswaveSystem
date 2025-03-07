package java_basic_08_Stream_Ramda;
/*
람다식
-자바에서 함수적 프로그래밍 지원하는 기법
-코트의 간결함 및 병렬처리 강화(Collection API 성능 효과적 개선) > Stream(데이터 제어 람다표현)

Java 객체지향프로그램 > 모든 함수는 클래스 or 인터페이스 내부에서 존재해야함 (클래스 내부의 함수 >> 메서드)

람다식 이해

함수(function) : 기본적인 동작을 정의

메서드(method) :  클래스 또는 인터페이스 내부에 정의된 함수

함수형 인터페이스(functional interface) : 내부에 단 1개의 추상메서드만 존재하는 인터페이스
@FunctionalInterface
interface MyFunction{
    void method();
}
----------------------------------
void add() {} -> add() 함수사용

객체지향
class A {
    void add(){

    }
}
----> A a = new A()  -->  a.add()
-----------------------------------
자바 ?? 고민
함수만 사용할 수 있는 새로운 문법 체계

질문 : 모든 인터페이스의 구현 메서드는 람다식으로 표현할 수 있나요?? -> NO

단 하나의 메서드만 필요로 한다 .... @FunctionalInterface 함수적 인터페이스 람다식 표현 가능

interface A{
    void call();
}

class B implements A{
    public void call(){

    }
}

A a = new B();
a.abc();
----------------------------------
1단계

익명 클래스

A a = new A(){
    void call(){

    }
}

a.call();
-----------------------------------
2단계

람다식 - 익명 클래스를 줄여쓰는 방법

A a = () -> {}
------------------------------------
연습
1.
@FunctionalInterface
interface A{
    void method();
}
->람다식으로
A a = () -> System.out.println();
------------------------------------------------
2.
@FunctionalInterface
interface B{
    void method(int a);
}
->람다식으로
B b = a -> System.out.println();
-------------------------------------------------
3.
@FunctionalInterface
interface C{
    int method();
}
->람다식으로
C c = () -> 4;
-------------------------------------------------
4.
@FunctionalInterface
interface D{
    double method(int a, double b);
}
->람다식으로
D d = (a,b) -> a+b;
----------------------------------------------------
----------------------------------------------------
람다식 활용
1. 함수적 인터페이스만 가능
2. 메서드 참조 (인스턴스 메서드 참조, 정적 메서드 참조)
3. 생성자 참조 (배열 생성자 참조, 클래스 생정자 참조)

interface A{
    void call(int a);
}

->익명클래스
A a = new A(){
    pubic void call(int a);
    System.out.println("a : " + a);
}

->람다식
A a = a -> System.out.println("a : " + a);


람다식 : 인스턴스 메서드 참조 타입 >> 이미 정의된 인스턴스의 메서드 참조 가능
interface A{
    void call();
}

class B{
    void method(){
        System.out.println("메서드");
    }
}

A a = A(){
    public void call(){
        B b = new B();
        b.method();
    }
}

람다식
A a = () -> {
    B b = new B();
    b.method();
}

--->더 줄이기
B b = new B();
A a = b::method;  //메서드 참조(그냥 문법임)

--->하나더 해보기
A a = (k) -> {
    System.out.println(k);
}

-> A a = System.out::println;  //메서드 참조 -> 그냥 parameter k 를 출력해버림

인스턴스에서 참조
클래스 객체::인스턴스 이름
 */

@FunctionalInterface
interface MyFunc{
    void method(int x);
}

@FunctionalInterface
interface MyFunc2{
    void method(int x, int y);
}

public class Lamda_4 {
    public static void main(String[] args) {
        //익명 클래스
        MyFunc myFunc = new MyFunc() {
            @Override
            public void method(int x) {
                System.out.println(x);
            }
        };
        myFunc.method(10);

        MyFunc2 myFunc2 = new MyFunc2() {
            public void method(int x, int y) {
                System.out.println(x+y);
            }
        };
        myFunc2.method(10,20);

        //람다식
        MyFunc myFunc3 = System.out::println;
        myFunc3.method(10);

        MyFunc2 myFunc4 = (x,y) -> System.out.println(x+y);
        myFunc4.method(10,20);
    }
}



















