package java_basic_oop.kosa.Ex;
/*
this 용법
객체 자신을 가르키는 this

1.원칙 : 객체생성시 (new) 생성자는 1개 호출
 */

//class Zcar {
//    String color;
//    String gearType;
//    int door;
//
//    //기본옵션
//    Zcar() {
//        this.color = "red";
//        this.gearType = "auto";
//        this.door = 4;
//    }
//
//    Zcar(String color, String gearType, int door) {
//        this.color = color;
//        this.gearType = gearType;
//        this.door = door;
//    }
//}

class Zcar {
    String color;
    String gearType;
    int door;

    //기본옵션
    Zcar() {
        this("red", 2);
    }

    Zcar(String color, int door) {
        this(color,"auto", door);
    }

    Zcar(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    //member field 초기화 코드는 반복되지 않고 .... 마지막 생성자가 가지고 있다.
    //this를 사용해서 여러개의 생성자를 호출할 수 있다. - 코드량의 감소 : 할당을 한번만 함.

    void zcarPrint(){
        System.out.println(this.color + ", " + this.gearType + ", " + this.door);
    }
}

public class Ex15_this2 {
    public static void main(String[] args) {
        Zcar zc = new Zcar();
        zc.zcarPrint();
    }
}
