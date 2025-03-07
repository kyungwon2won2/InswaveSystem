package java_basic_08_Stream_Ramda;
/*
람다식 기본 문법

(int a) -> System.out.println(a);
(타입 매개변수, ...) -> {실행문;}

1. 매개타입은 런타임시에 대입값에 따라서 자동으로 인식
(int a), (String a)  -----> (a) ->  {System.out.println(a);}

2. 하나의 매개변수만 있을 경우 괄호는 생략할 수 있다.
a -> {System.out.println(a);}

3. 하나의 실행문만 있다면 괄호 생략 가능
a -> System.out.println(a);

4. 매개변수가 없다면 괄호 생략할 수 없ㅅ음
() -> {실행문;}

5. 리턴값이 있는 경우, 그냥 return 문을 사용
(x,y) -> {return x+y;} // if 구문과 같은 논리 구문이 있으면 {} 생략 불가

6. 중괄호 {} 에 return 문만 있을 경우, 중괄호 생략가능
(x,y) -> x+y;
 */
@FunctionalInterface
interface MyFunction{
    void method();
}

public class Lamda_3 {
    public static void main(String[] args) {
        //먼저 익명 클래스
        MyFunction myFunction = new MyFunction() {
            @Override
            public void method() { //일회성으로 구현
                System.out.println("World");
            }
        };
        myFunction.method();

        //람다식으로 줄여보기
        MyFunction myFunction2 = () -> System.out.println("World");
        myFunction2.method();
    }
}
