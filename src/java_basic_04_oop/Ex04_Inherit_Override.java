package java_basic_04_oop;
/*
상속관계에 override(재정의) : 상속관계에서 자식이 부모의 함수를 재정의({...}안의 내용만 바꾸는것)
상속관계에서 자식클래스가 부모클래스의 메서드를 재정의하는 것.
재정의 : 틀()함수의 이름, 타입, parameter)의 변화가 없고, {...}안의 내용만 바꾸는것

오버로딩 : 메서드의 이름은 동일하지만 parameter와 return type을 다르게하여 함수의 다형성을 높여 사용하는것.
오버라이딩 : 상속관계에서 자식이 부모의 함수를 재정의하여 사용하는것.

문법
1.부모함수와 이름 동일
2.부모함수와 parameter 동일
3.부모함수와 return type 동일
4.실행블록안의 코드만 바꿔라
 */

class Point2{
    int x = 4;
    int y = 5;

    String getPosition(){
        return this.x + " " + this.y;
    }
}

class Point3 extends Point2{
    int z = 6;

    //컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공
    @Override
    String getPosition(){
        return this.x + " " + this.y + " " + this.z;
    }
}
public class Ex04_Inherit_Override {
    public static void main(String[] args) {
        Point2 point2 = new Point2();
        System.out.println(point2.getPosition());
    }
}
