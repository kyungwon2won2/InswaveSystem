package java_basic_04_oop;
/*
객체지향언어 3대
1.상속 2.캡슐화 3.다형성

다형성 : 상속관계에서 ... 여러가지 성질(상태)를 가질 수 있는 능력

JAVA : 상속관계에서 하나의 참조변수가 여러개의 타입을 가질 수 있는 것
> [하나의 참조변수] >> 부모타입
> [여러개의 타입] >> 부모를 상속받은 자식타입
*/

class Tv2{
    boolean power;
    int ch;

    void power(){
        this.power = !this.power;
    }

    void chUp(){
        this.ch++;
    }

    void chDown(){
        this.ch--;
    }
}

//자막이 나오는 Tv
class CapTv extends Tv2{
    //구체화, 특수화 내용(자신만의)
    String text;
    String captionText(){
        return this.text = "현재 자막 서비스 처리중 ... ";
    }
}

public class Ex10_Inherit_poly {
    public static void main(String[] args) {
        CapTv ct = new CapTv();
        ct.power();
        System.out.println(ct.power);
        ct.chUp();
        System.out.println(ct.ch);
        System.out.println(ct.captionText());
        /////////////////////////////////////////

        Tv2 tv2 = ct; //부모는 자식의 주소를 받을 수 있다.
        //상속관계에서 부모타입의 참조변수(tv2) 는 여러개의 자식타입 참조주소를 가질 수 있다.
        //단, 부모는 [자신의 자원만 접근가능]
        //***단, 재정의는 제외하고 (부모로 접근하더라도 자식의 기능을 사용한다.)
        System.out.println(ct.toString());
        System.out.println(tv2.toString());  // 주소는 같지만 볼 수 있는 영역은 다르다.
    }
}
