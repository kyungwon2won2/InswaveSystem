package java_basic_04_oop;
/*
객체지향 언어의 특징
1.상속 - 설계도 1장 아니고 여러장의 설계도(관계) > 재사용성
2.캡슐화(은닉화) - private
3.다형성(상속관계에서 부모타입은 자식타입의 주소를 가질 수 있다.)

상속
JAVA : child extends Base
C# : child : Base

특징
1.다중 상속 불가(단일 상속 원칙) - 계층적 상속만 지원 : 할아버지 -> 아버지 -> 아들
2.계층적 상속(여러개의 클래스를 상속)
3.다중 상속 지원 : interface - 상속도 맞긴하지만 다중 구현이 더 맞는 표현(여러개의 작은 약속을 모아서 큰 약속을 만듦)

상속
1.진정한 의미 :  야구선수, 농구선수, 축구선수 > 모두 다 사람. - 공통사항이 발생  ----------> **재사용성
2.단점 : 비용(초기 설계비용:시간), 부모 자식관계(커플링 : 현대적인 프로그래밍은 디커플링이 해야함 -> interface)
3.재사용성 > 설계 > 시간 > 재사용성 높아짐

모든 클래스는 메모리에 올라가야 사용이 가능하다.(구체화 : new ...)
Child child = new Child();

사용자가 만드는 모든 클래스는 부모 클래스를 가지고 있다.(Object)
class Car extends Object{  //평상시에는 생략
}
 */

class GrandFather{ //extends Object 생략 : 상속관계에서는 최상위 클래스 한놈이 Object를 대표로 상속받음
    public int gmoney = 5000;
    private int pmoney = 10000; //상속관계 접근 불가.. 무덤까지 가져갈거야. (public한 함수를 만들어서 접근하면 되긴함)
    public GrandFather(){
        System.out.println("GrandFather 생성자");
    }
}

class Father extends GrandFather{
    public int fmoney = 3000;
    public Father(){
        System.out.println("Father 생성자");
    }
}

class Child extends Father{
    public int cmoney = 100;
    public Child(){
        System.out.println("Child 생성자");
    }
}

public class Ex01_Inherit {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.gmoney);
        System.out.println(child.fmoney);
        System.out.println(child.cmoney);

    }

}
