package java_basic_04_oop;

import java_basic_04_oop.kr.or.sosa.Emp;

class Test2{
    int x = 100;

    void print(){
        System.out.println("부모함수 ..Test2.print()");
    }
}

class Test3 extends Test2{
    int x = 300; //부모자원 무시하기.. -> 문법적으로 문제는 없지만, 사용을 권하지는 않는다.

    @Override
    void print(){
        System.out.println("자식이 부모 함수를 재정의");
    }

    void print(String str){ //오버로딩
        System.out.println("나는 오버로딩한 함수" + str);
    }
}
public class Ex05_Inherit_Override {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.x);

        test3.print();
        test3.print(" ㅋㅋㅋㅋ");

        Emp emp = new Emp(7902, "홍길동");
        System.out.println(emp);
        System.out.println(emp.toString()); //toString()을 재정의하지 않았을 시, 둘다 주소값이 나온다.
    }
}
