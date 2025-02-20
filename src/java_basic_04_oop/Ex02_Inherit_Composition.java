package java_basic_04_oop;

import java.util.Arrays;

/*
개발 -> 한개의 클래스만 가지고 개발x
설계도 한장에 모든 업무를 구현하는것은 불가능. -> 업무별로 설계도를 여러개로 나눈다 ... 문제발생(기준, 논리)

[관계에 대한 기준]
1.is ~ a : 은(는) ~이다.  -> 상속관계 (부모를 뒤에 놓는다.)   ex)원은 도형이다. (원 extends 도현)
2.has ~ a : 은(는) ~을 가지고있다.  -> 포함관계-클래스 안에 클래스(부품)   ex)경찰은 권총을 가지고있다.

원은 점을 가지고있다. 원 has ~ a 점
>>class 원 {점이라는 부품이 member field}
>>class 점 {x, y}
-------------------------------------
원은 도형이다.
삼각형은 도형이다.
사각형은 도형이다.

도형 분모(공통적) : 그리다, 색상 : (추상화, 일반화)
원 : 반지름, 한 점 : (구체화, 특수화)
점 : 좌표값(x, y)
원은 점을 가지고있다.
사각형은 점을 가지고있다.(포함)
--------------------------------------
class Shape{색상, 그리다} >> 상속관계에서 부모
class Point{좌표값} >> 포함관계 >> 부품

구체화, 특수화 : Circle, Triangle
 */
class Shape {
    String color = "gold";
    void draw(){
        System.out.println("도형을 그리다");
    }
}

class Point{
    int x;
    int y;

    Point(){
        this(1, 1);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
원을 만들어라 (원의 정의 : 원은 한점과 반지름을 가지고있다. 그리고 색상도 가지고 그림을 그릴 수 있다.)
1.원은 도형이다.
2.원은 점을 가지고 있다.
3.원 특수화 구체화 : 반지름

원의 반지름은 초기값 10을 가진다.
원의 좌표의 초기값 (10, 15)를 가진다.
초기값을 설정하지 않으며 반지름과 점의 값을 입력 받을 수 있다.
 */
class Circle extends Shape{
    int radius;
    Point point;

    public Circle(){
        this(10, new Point(10,15));
    }

    public Circle(int radius, Point point) {
        this.radius = radius;
        this.point = point;
    }

}
/*
삼각형 설계도를 만드세요.
삼각형은 3개의 점과 색상과 그리다 기능을 가지고 있다.
hint) Shape, Point 제공 받아서 만드세요.
default 값으로 삼각형 만들수 있고, 3개의 좌표값을 입력받아서 그릴수도 있다.
 */
class Triangle extends Shape{
    Point[] trianglePoints;

    public Triangle(){
        this(new Point[]{new Point(0, 0), new Point(0, 1), new Point(1, 0)});
    }

    public Triangle( Point[] trianglePoints) {
        this.trianglePoints = trianglePoints;
    }

    public void printTrianglePoints(){
        for(Point point : this.trianglePoints){
            System.out.println(point.x + "  " + point.y);
        }
    }
}
public class Ex02_Inherit_Composition {
    public static void main(String[] args) {
        //default로 원을 생성
        Circle circle = new Circle();
        System.out.println(circle.radius);
        System.out.println(circle.color);
        System.out.println(circle.point.x);
        System.out.println(circle.point.y);
        circle.draw();

        //내가 원하는대로 원을 생성
        Point point = new Point(111, 222);
        Circle circle2 = new Circle(100, point);

        //default로 삼각형 생성
        Triangle triangle = new Triangle();
        triangle.printTrianglePoints();
    }
}
