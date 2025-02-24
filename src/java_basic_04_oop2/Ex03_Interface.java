package java_basic_04_oop2;
/*
인터페이스 : 약속, 규칙, 규약, 표준을 만드는 것.
 -> 소프트웨어 설계의 최상위 단계 : 무에서 유를 창조하는 것.
초급개발자 : 표준을 만드는 것보다 만들어진 표준을 잘 사용하는 것. (java api : Collection - list, set, map 인터페이스)
약속만 가지고... 구현체가 없다...

**원칙적으로 : 인터페이스는 추상자원만 갖는다. (자바 버전이 올라가면서 몇가지 추가)
    - public인 상수 필드
    - public 추상 메서드 .... 이것만 가지고 있으면 강제적 구현..    ....->일단은 이거 두가지만 알아보자.

    - public default method : 예외적으로 구현부를 가질 수 있다.......잘 안써서 나중에..
    - public static method : 예외적으로 구현부를 가질 수 있다.........잘 안써서 나중에...
    - private method : 예외적으로 구현부를 가질 수 있다.......잘 안써서 나중에...
    - private static method : 예외적으로 구현부를 가질 수 있다.......잘 안써서 나중에...

추상 클래스와 인터페이스의 공통점
1.미완성 자원을 가지고있다.
2.스스로 객체생성 불가능(new 연산자를 통해서 직접 객체 생성 불가 : 미완성이니까)

추상 클래스와 인터페이스의 차이점
1.추상클래스는 완성된 코드 + 미완성 코드, 인터페이스는 모두 미완성

사용방법
추상클래스는 extends
인터페이스는 implements - 여러개의 약속을 큰 약속으로 만들 수 있다.

-> 둘다 목적은 강제적 구현(재정의)

추상클래스와 인터페이스 다른점
추상클래스(완성+미완성) 그러나 인터페이스는 전체 미완성 (상수 + default 함수)
원칙적으로 클래스는 다중 상속 금지 > 계층적 상속 또는 포함 관계로 구현
그러나 인터페이스는 다중상속(구현) 가능 > 여러개의 인터페이스를 모아서 큰 인터페이스를 만들 수 있다.

Tip) 인터페이스가 다른 인터페이스를 상속 가능

초급 개발자 시선 :
1.인터페이스를 다형성 입장에서 접근해서 보자.(인터페이스는 모든 타입의 부모가 될 수 있다.)
2.***서로 연관성이 없는 클래스를 하나로 묶어준다. (같은 부모를 가지게 함으로써..형제가 되어버림)
3.JAVA API가 제공하는 인터페이스 사용하는 관점에서 (Collection, I/O, ...)
4.인터페이스 해석 : ~able (할수있다, 가능성) - 날 수 있구나, 수리할 수 있구나
5.객체가 연결 고리(객체가 소통) - 같은 부모를 만들면서... 다형성

[구현]
interface 이름
1.실제 구현부를 가지고 있지 않다 > 실행블록이 없다 > 약속 > (실행블록이 없다)
2.interface Ia{void move();} > 구현은 강제적 재정의

생성방법
1.[public static final] int VERSION = 1.0;
2.[public abstract] void run();
-> 어차피 [ ]안의 내용은 다 동일 > 생략

ex)
1. interface Able { }

2. interface Able { int NUM = 100; }

3. interface Able {void run(); }
 */
interface Ia{
    int AGE = 100; // public static final 생략
    String GENDER = "남"; // public static final 생략
    String print(); // public abstract 생략
    void message(String str); // public abstract 생략
}

interface Ib{
    void info();
}

class Test2 extends Object implements Ia{
    //인터페이스가 가지고 있는 추상자원은 강제적 구현 목적
    @Override
    public String print() {
        return null;
    }

    @Override
    public void message(String str) {
        System.out.println("재정의 : " + str);
    }
}

//////다중 구현
class Test3 implements Ia, Ib{

    @Override
    public String print() {
        return null;
    }

    @Override
    public void message(String str) {

    }

    @Override
    public void info() {

    }
}

public class Ex03_Interface {
    public static void main(String[] args) {
        Test2 t2 = new Test2();
        //////////////////////////////////
        Ia ia = t2; //** 오늘의 포인트 : 부모 인터페이스 ia 타입은 자식의 객체의 주소를 가질 수 있다. - 다형성
        /////////////////////////////////
        ia.message("재정의");

        Test3 t3 = new Test3();
        Ia ia2 = t3;
        Ib ib2 = t3; //Test3의 부모는 Ia이다.  Test3의 부모는 Ib이다.
    }
}
