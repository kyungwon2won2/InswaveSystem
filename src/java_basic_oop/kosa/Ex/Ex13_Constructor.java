package java_basic_oop.kosa.Ex;

class Car7{
    String carColor;
    int door;

    Car7(){
        carColor = "blue";
        door = 4;
    }

    Car7(int num){
        carColor = "blue";
        door = num;
    }

    Car7(String color){
        carColor = color;
        door = 4;
    }

    Car7(int num, String color){
        carColor = color;
        door = num;
    }

    void carInfoPrint(){
        System.out.printf("color: %s  door: %d",carColor,door);
    }
}

public class Ex13_Constructor {
    public static void main(String[] args) {
        //default
        Car7 car1 = new Car7();
        car1.carInfoPrint();

    }
}
