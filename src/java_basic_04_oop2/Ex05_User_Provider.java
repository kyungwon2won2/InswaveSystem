package java_basic_04_oop2;
/*
user(사용자)  <>  provider(제공자)

class A {}
class B {}

관계 : A는 B를 사용합니다.
1.상속 : A extends B
2.포함 : A { B b; } A라는 클래스가 member field B를 가지는 것.
    2.1.부분 : 라이프사이클(생명주기) >> 학교와 학생 >> 학교 필요하면 학생을 받는것 >> 다르다
    2.2.전체 : 라이프사이클(생명주기) >> 동일 >> 자동차 엔진

class B {}
class A {
    B b; //A는 B를 사용합니다.(포함)
    A(){
        b = new B();
    }
}
-main 함수-
A a = new A();
A객체, B객체 생성
a.b.b의 자원
a = null;   ---> a.b.b 자원 접근 불가 (생명주기가 동일)

포함관계
>> B는 독자생성 불가능 >> A라는 객체가 생성되어야 B도 생성
>> 공동운명체(전체집합)
>> 자동차와 엔진, 컴퓨터와 CPU

class B {}
class A {
    B b; //포함관계
    A(){

    }
    //method
    void m(B b){ //선택적 (필요하면 부를 수 있고, 호출하지 않을 수도 있다.) , 옵션
        this.b = b;
    }
}
-main 함수-
A a = new A();
B b = new B();
a.m(b); //필요에 따라서 b객체 생성
a = null;
>> a가 null이 되어도 b 객체는 사라지지 않음. -> 운명 공동체가 아니다
>> 부분집합
>> 노트북과 마우스, 학교와 학생

A 는 B (사용)참조합니다. >> 포함 >> A라는 클래스가 B를 member field로 가짐 >> 결정(전체, 부분)
 */
interface Icall{
    void m(); // public abstract void m(); - 일반적으로 앞에부분을 생략한다.
}

class D implements Icall{

    @Override
    public void m() {
        System.out.println("D .... Icall 인터페이스의 m() 정의");
    }
}

class F implements Icall{

    @Override
    public void m() {
        System.out.println("F .... Icall 인터페이스의 m() 정의");
    }
}

/*
Today Point**
현대적인 프로그래밍 방식은 > 유연성 중요 > 대충 만들어서 대충써도 돌아갔으면 좋겠다 ... 느슨하게 .. > interface (다형성)
 */
class C{
    void method(Icall icall){ //D, F 객체, 실제로는 아직 없지만 앞으로 만들어진다면 올 수 있있도록 >> interface 사용
        icall.m(); // 전자체품 매장의 buy(Product) 와 같음... >> 다형성
    }
}
public class Ex05_User_Provider {
    public static void main(String[] args) {
        C c = new C();
        D d = new D();
        F f = new F();

        c.method(d);
        c.method(f);
    }
}
