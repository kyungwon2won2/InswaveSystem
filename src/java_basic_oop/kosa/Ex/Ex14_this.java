package java_basic_oop.kosa.Ex;
/*
this
1.객체 자신을 가르키는 this (앞으로 생성될 객체의 주소를 담을 곳이라고 가정하고) 편리성
2.this 객체 자신 : 생성자 호출 (원칙적으로 생성자 함수는 객체 생성시 한개 호출)
 */

class Test5{
    int i;
    int j;

    Test5(){};
    Test5(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Book2{
    String bookName;

    public Book2(String bookName) {
        this.bookName = bookName;
    }
}

class Socar{
    String color;
    String gearType;
    int door;

    //기본옵션
    Socar(){
        this.color = "red";
        this.gearType = "auto";
        this.door = 4;
    }

    Socar(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    void socarPrint(){
        System.out.println(this.color + ", " + this.gearType + ", " + this.door);
    }
}

public class Ex14_this {
    public static void main(String[] args) {
        Socar socar = new Socar("gold", "auto", 6);
        socar.socarPrint();
    }
}
