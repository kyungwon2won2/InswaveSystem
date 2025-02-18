package java_basic_oop.Ex;

class Vclass{
    int iv;//instance variable - heap 영역 : garbage collector 소멸
    static int cv; //static variable - class area 영역 : 프로그램 종료 소멸
    /*
    1.클래스 변수 = static variable - 객체간 공유자원
    2.목적 : 정보를 담는 것 (생성되는 모든 객체가 공유하는 정보)
        생성되는 객체(heap)
    3.접근방법 - 1. class 이름, static 자원 - java_basic_oop.kosa.Ex.Vclass.cv = 100; // new 없이 사용가능
             - 2. java_basic_oop.kosa.Ex.Vclass vc = new java_basic_oop.kosa.Ex.Vclass(); vc.cv 접근 가능(주소를 가지고 있으니까 가능)
    4.생성시점 : jvm이 메모리를 생성하고 클래스를 분석하고 class area에 올리다가 static을 만나면 메모리에 올린다.
    **static 자원은 객체 생성보다 먼저 메모리에 올라가있다. (new하기전에 먼저)
     */

    void method(){
        int lv = 0;//local variable - stack 영역
        for(int i=0; i<200; i++){
            //block variable
        }
    }

}


public class Ex05_Variable_Scope {
    public static void main(String[] args) {
        Vclass.cv = 200;
        Vclass vc = new Vclass();
        Vclass vc2 = new Vclass();
        Vclass vc3 = new Vclass();
    }
}


