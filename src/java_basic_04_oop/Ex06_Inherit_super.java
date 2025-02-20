package java_basic_04_oop;
/*
객체 하나만 가지고 놀때는
this : 객체 자신을 가르키는 this, 생성자를 호출하는 this

상속관계
부모 : 자식

super : 상속관계에서 자식이 부모의 자원에 접근하도록 하는 주소 - 상속관계에서 부모접근
1.상속관계에서 부모자원에 접근
2.상속관계에서 부모의 생성자를 호출

super
1.부모의 주소를 가르키는 super
2.부모의 생성자를 호풀하는 super
 */
class Base{
    String baseName;
    //default
    Base(){
        System.out.println("부모 클래스의 기본 생성자");
    }
    Base(String baseName){
        this.baseName = baseName;
        System.out.println("baseName : " + this.baseName);
    }
    void method(){
        System.out.println("부모 method");
    }
}

class Derived extends Base{
    String dName;
    Derived(){
        System.out.println("자식 클래스의 기본 생성자");
    }
    Derived(String dName){
        super(dName); // ----------이걸로 해결
        this.dName = dName;
        System.out.println("dName : " + this.dName);
    }
    //부모의 method()를 잘 쓰고 있었는데 자식이 갑자기 재정의하는 상황.
    @Override
    void method(){
        System.out.println("부모 method() 재정의");
    }
    //다시 부모가 그리워진 자식.. 부모의 method()를 부르고싶음. -> @Override를 걸면 이상태로는 불가능
    void pMethod(){
        //따로 구현해서
        //재정의된 함수가 있어도 부모의 주소를 가지고 접근 -> super 이용
        super.method();
    }
}
public class Ex06_Inherit_super {
    public static void main(String[] args) {
//        Derived d = new Derived();
//        d.baseName = "할배";
//        d.dName = "나";
        Derived d2 = new Derived("홍길동");
        /*
        문제...
        나는 부모쪽의 오버로딩된 생성자 부모 생성자 호출하고싶다. ->일반적으로 하면 안됨.
        ------>super()로 해결
        -->상속관계에서 자식이 부모의 자원에 접근할 수 있는 유일한 방법 super() : 상속관계에서의 this 느낌
         */
        d2.method();
        d2.pMethod();
    }
}
