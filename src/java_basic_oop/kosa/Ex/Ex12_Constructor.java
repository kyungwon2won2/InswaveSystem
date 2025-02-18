package java_basic_oop.kosa.Ex;

/*
class의 구성요소
member field + method + constructor method

1.생성자 함수(constructor)
    -특수한 목적의 함수
    -목적 : member field 초기화 - static{}, {}
2.일반함수와의 차이점
    -함수의 이름은 클래스 이름과 동일하게
    -겍체 생성과 함께 동시에 호출(return type 존재x)
    -실행시점 : new객체 생성 > heap객체 생성 > member field > 자동으로 호출되는 함수
    -return type x -> void -> 생략가능
3.설계도 > 생서자 > why? : 생성되는 객체마다 강제적으로 member field를 초기화하고 싶다.
4.생성자는 여러개 만들 수 있다.
    -오버로딩을 이용해서 만들수 있음(강제구현)
 */

class Car{

    String carName = "포니";

//    Car(){} // default 생성자 - 자동생성
    Car(){
        System.out.println("개발자가 직접구현한 생성자");
        this.carName = "내가 원하는 이름으로 생성자가..";
    }
}

class Car2{
    String carName;

}

class Car3{
    String carName;
    Car3(){ //얘가 default constructor가 됨
        carName = "포니"; //객체 생성시 carName을 포니로 초기화
    }
}

class Car4{ //자동차를 만드는 방법은 2가지 - 1.기본 생성자 사용 2.사용자 정의 생성자 사용
    String carName;
    Car4(){
        carName = "default";
    }
    Car4(String name){
        carName = name;
    }
}

class Car5{
    String carName;
    //overloading된 생성자를 하나라도 구현한다면 default 생성자를 구현해서 사용해야한다.
    public Car5(String name){
        carName = name;
    }
}

class Car6{
    String carColor;
    int door;

    Car6(){
        carColor = "blue";
        door = 4;
    }

    Car6(int num){
        carColor = "blue";
        door = num;
    }

    Car6(String color){
        carColor = color;
        door = 4;
    }

    Car6(int num, String color){
        carColor = color;
        door = num;
    }
}

public class Ex12_Constructor {
    public static void main(String[] args) {
        Car car = new Car(); // 만약 default 생서자 함수를 구현하지 않으면 컴파일러가 자동으로 생성
        System.out.println(car.carName);

        Car4 defaultCar = new Car4();
        Car4 bmw = new Car4("bmw");
    }
}
