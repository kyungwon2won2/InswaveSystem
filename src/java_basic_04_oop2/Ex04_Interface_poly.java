package java_basic_04_oop2;

class Unit2{
    int hitPoint; //기본 에너지
    final int MAX_HP; //최대 에너지
    Unit2(int hp){ //사용자 정의 생성자
        this.MAX_HP = hp;
    }
}

//지상유닛, 공중유닛, 건물

//지상유닛
class GroundUnit extends Unit2{
    GroundUnit(int hp) { // Unit2를 상속했기 때문에 Unit2의 생성자가 호출되는데, hp가 parameter로 필요하기때문에 GroundUnit의 생성자에서 super(hp)가 호출되어야함.
                        // super(hp)가 없다면 Unit2의 기본 생성자가 없어서 컴파일 에러가 발생하게된다.
        super(hp);
    }
}

//공중유닛
class AirUnit extends Unit2{
    AirUnit(int hp) {
        super(hp);
    }
}

//건물
class CommandCenter implements Irepairable{

}

//Point : 인터페이스 - ~할 수 있는(able)
//tank와 scv, commandcenter를 묶어준다.
interface Irepairable{

}

//유닛
class Tank2 extends GroundUnit implements Irepairable{

    Tank2() {
        super(50);
        this.hitPoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "Tank2";
    }
}

class Marine2 extends GroundUnit{
    Marine2() {
        super(50);
        this.hitPoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "Marine2";
    }

}

//유닛 (광물캐는 유닛) - 수리 .. 탱크가 망가지면 고칠 수 있음
class Scv extends GroundUnit implements Irepairable{
    Scv() {
        super(50);
        this.hitPoint = MAX_HP;
    }

    @Override
    public String toString() {
        return "Scv";
    }

    //SCV만의 구체화, 특수화 고유한 기능 구현
    //수리하다 - repair
    //Tank2, Scv, CommandCenter 만 수리가능

    //GroundUnit - Tank2, Marine2, Scv의 부모 -> 근데 marine은 void repair(Ground unit)에 들어가면 안된다
    //Unit으로 받으면 AirUnit...이 문제가됨.

    //--> interface Irepairalbe 이용 : 서로 연관성이 없었던 클래스에 같은 부모를 만들어주었음.
    /*
    class CommandCenter implements Irepairable {}
    class Tank2 extends GroundUnit implements Irepairable {}
    class Scv extends GroundUnit implements Irepairable {}

    --> 같은 부모 : 다형성
     */
    void repair(Irepairable repairUnit){ //구현한 자식 객체의 주소가 들어오게 됨.
        //부모타입은 자신의 자원만 접근 : 추상 자원이 없음.
        //Tank2, Scv, CommandCenter가 올 수 있는데 3가지가 수리하는 방법이 다름.
        //Tank2, scv >> HP만 올려주면됨.
        //CommandCenter는 다른 방법으로 수리해야함.

        //1.tank랑 scv만 오면 Unit2
        //Unit2 unit = (Unit2)repairUnit; //down casting
        //Unit2 unit = unit.MAX_HP;
        //답이 아님 - commandcenter에서 문제발생

        //타입을 물어보고 그 타입에 맞게 논리를 나누어서...
        if(repairUnit instanceof Unit2){
            //Tank, scv
            Unit2 unit = (Unit2)repairUnit; //down casting
            unit.hitPoint = this.MAX_HP;
        }else{
            //건물
            System.out.println("다른 방법으로 충전을 통해서 건물 복원");
        }
    }
}
public class Ex04_Interface_poly {
    public static void main(String[] args) {
        Tank2 tank = new Tank2();
        Marine2 marine = new Marine2();
        Scv scv = new Scv();

        CommandCenter center = new CommandCenter();

        //전투
        tank.hitPoint -= 20;
        System.out.println("탱크 : " + tank.hitPoint);
        System.out.println("scv 수리요청");
        scv.repair(tank);
        System.out.println("탱크 수리 완료 : " + tank.hitPoint);

        scv.hitPoint -= 30;
        System.out.println("scv : " + scv.hitPoint);
        System.out.println("scv 수리요청");
        scv.repair(scv);
        System.out.println("scv 수리 완료 : " + scv.hitPoint);

        scv.repair(center);
    }
}
