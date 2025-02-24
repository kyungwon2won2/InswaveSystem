package java_basic_04_oop2;
/*
추상 클래스 (미완성 클래스) : 완성되지 않은 설계도
1.완성된 코드 + 미완성된 코드
2.미완성 함수 >> 실행 블럭이 없는 함수 >> public void run(); >> 원칙은 public void run(){실행블럭}
    -> 미완성 함수는 구현을 통해서 사용가능 (상속받은 클래스) >> **강제적 오버라이드 구현
3.미완성된 클래스(스스로 객체생성이 불가능)

추상 클래스 설계도 > 미완성(미완성 함수) > 설계자의 의도 > 난 너희를 믿지 못해 > 강제적 구현 목적으로

추상 클래스는 상속을 기반으로 한다.
 */
class Car{
    void run(){ //실행 블럭 : 정상적인 함수

    }
}

class Hcar extends Car{
    //팀원이 오버라이드해서 뭔가를 구현했으면 좋겠다...
    @Override
    void run(){
        System.out.println("재정의의 강제성이 없음...");
    }
}

/////////////////////////////강제적 구현을 목적으로하는 클래스(미완성 클래스)
abstract class ABclass{
    int pos;
    void run(){
        pos++;
    }
    //재정의를 강제하는 함수를 만들자 - 추상함수
    abstract  void stop(); //실행블럭이 없는 >> 상속 클래스 >> 강제적으로 반드시 구현해야함
}

class Child extends ABclass{

    @Override
    void stop() {
        //이부분은 구현하는 사람 마음대로 구현.
        this.pos = 0;
        System.out.println("stop : posr값 -> " + this.pos);
    }
}

class Child2 extends ABclass{

    @Override
    void stop() {
        //이부분은 구현하는 사람 마음대로 구현.
        this.pos = -1;
        System.out.println("stop : posr값 -> " + this.pos);
    }
}
public class Ex01_abstract_class {
    public static void main(String[] args) {
        Hcar hcar = new Hcar();
        hcar.run();

        Child child = new Child();
        child.run();
        child.stop();

        Child2 child2 = new Child2();
        child2.run();
        child2.stop();

        //다형성
        ABclass ab = child;
        //상속관계에서 부모 타입의 참조변수는 자식 객체의 주소를 가질 수 있다.(다형성)
        //부모는 자신의 것만 가질수 있다.
        //단 재정의가 되었다면 부모로 접근하더라도 자식 자원을 사용한다.
        ab.run();
        ab.stop(); //부모 추상함수 구현되어 있지 않다. -> 구현된 자식쪽으로 내려보냄.. 구현된 코드를 볼 수 있따.
    }
}
