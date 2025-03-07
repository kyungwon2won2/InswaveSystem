package java_basic_03_etc;
/*
1. 중첩클래스(클래스 안에 클래스가 올 수 있다.)
1.1. inner class
1.2. outer, inner 나누어지는데, 장점은 outer 클래스의 private 자원을 inner 가 접근 가능 -> 코드 간소화
1.3. awt, swing(JAVA 의 CS-메모장, 그림판), 안드로이드앱(이벤트 처리)에 주로 사용

2. 익명클래스(이름 없는 클래스)
2.1. 클래스를 정의하지 않고 객체를 만드는 방법 > 추상클래스, 인터페이스는 스스로 객체 생성 불가 > 1회용 클래스-익명클래스 > 재사용 불가능
2.2. 이벤트 처리, 쓰레드, 람다식, 스트림(Stream API)
 */
class OuterClass{
    public int pdata = 10;
    private int data = 30;

    //inner class (outer 자원에 대한 접근 용이)
    class InnerClass{
        void msg(){
            System.out.println("outer class data : " + data);
            System.out.println("outer class pdata : " + pdata);
        }
    }
}

abstract class Person{
    abstract void eat();
}
//추상 클래스 미완성 > 완성
class Man extends Person{
    @Override
    void eat() {
        System.out.println("Person 의 eat 함수 재정의");
    }
}

interface IEat{
    void eat();
}

class Test{
    void method(IEat e){ //전형적인 다형성(IEat )
        e.eat();
    }
}

//문법적인 접근만 확인해보자.
public class Ex13_InnerClass  {
    public Ex13_InnerClass(String message) {
        OuterClass outObj = new OuterClass();
        System.out.println("public field만 접근가능" + outObj.pdata);

        OuterClass.InnerClass innerObj = outObj.new InnerClass(); //문법
        innerObj.msg();

        ///기본////////////////////////////////////////////
        Man man = new Man();
        man.eat();

        Person p = man;
        p.eat(); //자식 객체의 eat() - 재정의 됐기 때문

        Person p2 = new Man();
        p2.eat();
        ///////////////////////////////////////////////////
        /*
        추상 클래스
        추상 클래스는 스스로 객체 생성 불가능(미완성이기 때문에)
        추상 클래스 상속하는 클래스를 만들고 ㅅ용

        한번만 쓰고싶다(재사용하지 않을 것이다.)

        Person 을 상속하는 클래스 없이 (이름 없이(클래스)) 1회성 사용 가능
         */
        //Today POINT
        // Anonymous Class
        Person person = new Person() {
            @Override
            void eat() {
                System.out.println("익명 클래스를 통한 객체 생성");
            }
        };
        person.eat();

        //////////////////////////////////////////////////////////////////////////
        // TODAY POINT
        //(Anonymous Class)
        Test t = new Test();

        t.method(new IEat() {
            @Override
            public void eat() {
                System.out.println("한번만 인터페이스 직접 구현 : 클래스 없이 ");
            }
        }); // 정식 : interface IEat 구현하는 클래스 만들고  그 클래스  new 주소를 만들고 ...

    }
}
