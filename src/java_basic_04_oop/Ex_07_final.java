package java_basic_04_oop;
/*
변수 <-> 상수
상수 : 한번 값이 초기화 되면 변경불가 (고유값 - 주민번호, 수학 관련 함수 Math.PI, 시스템 번호)
상수 관용적 대문자
final int NUM = 100;

final 키워드
1.클래스의 final  :  final class Car{} >> 상속금지 >> 너가 마지막
    - ex) public final class Math
2.함수의 final  :  public final void print(){} >> 상속관계에서 재정의 하지마라.
3.변수의 final  :  final int data; >> 상수

상수설계
final : (객체생성시라던가)한번은 내가 원하는 값으로 초기화 하겠다. - 내가 원하는 상수
static final : 모든 영역에서 고정된 값으로 사용하는 함수 ex)Math.PI - 그냥 정해져있는 상수
 */

class Vcard{
    final String KIND = "heart";
    final int NUM = 10;

    void method(){
        System.out.println(Math.PI); //static final pi
    }
}

class Vcard2{
    final String KIND;
    final int NUM;

    //생성자를 통해서 값 초기화 안하고 쓸수있음 -> 기본 생성자 사용 불가
    public Vcard2(String KIND, int NUM) {
        this.KIND = KIND;
        this.NUM = NUM;
    }

    @Override
    public String toString() {
        return "Vcard2{" +
                "KIND='" + KIND + '\'' +
                ", NUM=" + NUM +
                '}';
    }
}
public class Ex_07_final {
    public static void main(String[] args) {
        Vcard vcard = new Vcard();
        System.out.println(vcard.KIND);
        vcard.method();

        Vcard2 vcard2 = new Vcard2("spade", 1);
        System.out.println(vcard2.toString());
        Vcard2 vcard3 = new Vcard2("spade", 3);
        System.out.println(vcard3.toString());
        Vcard2 vcard4 = new Vcard2("heart", 1);
        System.out.println(vcard4.toString());
    }
}
