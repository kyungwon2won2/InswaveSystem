package java_basic_04_oop2;
/*
게임 : 유닛(Unit)
unit : 공통기능 (이동 좌표, 이동, 멈춤) : 충상화, 일반화 자원
       이동방법은 다르다(이동 방법은 unit 마다 별도로 반드시 구현해야함.)
class Unit{ void move(); } -> move의 강제성이 없음.
고민.. 추상 클래스의 [추상함수] !!
 */
abstract class Unit{
    int x,y;
    void stop(){
        System.out.println("Unit stop");
    }
    //이동 - 유닛마다 다르게, 강제적으로
    abstract void move(int x, int y); // 실행 블럭을 만들지 않는다. -> 추상함수(미완성)
}

class Tank extends Unit{
    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Tank가 소리내며 이동 : " + this.x + " , " + this.y);
    }
    //필요에 따라서 구체화,특수화된 기능 구현 : Tank 만의 고유한 기능
    void chaneMode(){
        System.out.println("탱크 모드 변환");
    }
}

class Marine extends Unit{

    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Marine이 뛰면서 이동 : " + this.x + " , " + this.y);
    }
    //특수화, 구체화
    void stimPack(){
        System.out.println("스팀팩 기능");
    }
}

class Dropship extends Unit{
    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Dropship이 하늘로 이동 : " + this.x + " , " + this.y);
    }
    //특수화, 구체화
    void load(){
        System.out.println("Unit load");
    }
    void unload(){
        System.out.println("Unit unload");
    }
}
public class Ex02_abstract_class {
    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move(550, 250);
        tank.stop();
        tank.chaneMode();

        Marine marine = new Marine();
        marine.move(200, 300);
        marine.stop();
        marine.stimPack();

        //**Today Point**
        //다형성...타입 비교 -> instanceof (객체의 타입을 비교하는 연산자 true, false)
        if(tank instanceof Unit){
            //객체        //타입
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        if(tank instanceof Tank){
            //객체        //타입
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        //***배열과 다형성의 결합
        //1. tank 3대를 만들고, 같은 좌표 (600, 300)으로 이동시커라.
        Tank[] tanks = {new Tank(), new Tank(), new Tank()};
        for (Tank value : tanks) {
            value.move(600, 300);
        }
        //2. 여러개의 tank 1대, marine 1사람, dropship 1대 생성하고 같은좌표 (666, 888)으로 이동시켜라.
        Unit[] units = {new Tank(), new Marine(), new Dropship()};
        for (Unit unit : units) {
            unit.move(666, 888);
        }

    }
}
