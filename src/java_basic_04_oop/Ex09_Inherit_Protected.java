package java_basic_04_oop;

import java_basic_04_oop.kr.or.sosa.Bird;

//Bird > 날수있다, 빠르다
class Bi extends Bird{
    //protected는 상속관계에서 사용하려면 재정의를 강제해야한다.
    //여기서 moveFast()를 구현해주지 않으면, 상속관계더라도 Bi.moveFast()를 사용하지 못한다.
}

class Ostrich extends Bird{
    //구체화, 특수화
    void run(){
        System.out.println("run....");
    }
    @Override
    public void moveFast(){
        //재정의니까 안에 코드는 맘대로
        run();
    }
}

public class Ex09_Inherit_Protected {
    public static void main(String[] args) {
//        Bird bird = new Bird();
//        bird.moveFast();
        Bi bi = new Bi();

        Ostrich os = new Ostrich();
        os.moveFast();
    }
}
