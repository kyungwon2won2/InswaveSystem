package java_basic_01_oop.src;
/*
우리 회사는 비행기를 주문 제작 판매하는 회사입니다.
우리 회사는 비행기를 생산하는 설계도를 만들려고 합니다.

요구사항
1.비행기를 생산하고 그리고 비행기의 이름과 번호를 부여해야한다.
2.비행기가 생상되면 비행기의 이름과 번호가 맞게 부여되는지 확인하는 작업을 할 수 있다. - 출력
3.공장장은 현재까지 만들어진 비행기의 총 누적대수를 확인 할 수 있다.

힌트) 비행기 1대 객체 1개
AirPlane air101 = new AirPlane();
air101.자원="대한항공"
air101.자원 = 101;
비행기 이름, 번호 출력
총비행기수 : 4대..

**생성자 금지
**this 사용금지
 */


// airplane 1차버전

//public class AirPlane {
//    private String name;
//    private int num;
//
//    private static int cnt;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setData(String text, int no) {
//        name = text;
//        num = no;
//        cnt++;
//        printData();
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//
//    public void printData(){
//        System.out.println("이름 : " + name + "번호 : " + num);
//    }
//
//    public void printCnt(){
//        System.out.println("총대수 : " + cnt);
//    }
//
//}



// 2차 버전
public class AirPlane {
    private String name;
    private int num;

    private static int cnt;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }


    public AirPlane(String name, int num){
        this.name = name;
        this.num = num;
        cnt++;
        printData();
    }

    public void printData(){
        System.out.println("이름 : " + name + "번호 : " + num);
    }

    public void printCnt(){
        System.out.println("총대수 : " + cnt);
    }

}
