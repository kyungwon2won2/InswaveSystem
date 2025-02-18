package java_basic_oop.kosa.Ex;

/*
함수 사용 parameter 값 전달 or 주소값(참조값) ref
call by value(값 전달) / call by reference(주소값 전달)
 */

class Data{
    int i;

}
public class Ex10_Method_Call {

    static void scall(Data sdata){ //parameter Data 클래스 객체의 주소를 받겠다.
        System.out.println("함수 : " + sdata.i);
        sdata.i = 1111;
    }

    static void vcall(int x){ //int 타입을 가지는 값을 받겠다.
        System.out.println("before x : " + x);
        x = 8888;
        System.out.println("after x : " + x);
    }

    public static void main(String[] args){

        Data d = new Data(); //d 참조변수
        d.i = 100;
        System.out.println("d.i : " + d.i); //-> 100

        scall(d);
        System.out.println("d.i : " + d.i); //-> 1111

       //-----------------------------------

        vcall(d.i); // i라는 변수 : 1111
        System.out.println("call by value after d.i : " + d.i); //-> 1111

    }
}
