package java_basic_01_oop.Ex;
/*
초기화
1. static variable : 공유자원(객체간 공유자원)
2. instance variable : 생성되는 객체마다 다른 값을 가지겠다.

두 자원은 default값
초기화 필요에 따라서 할 수도 있고 안할 수도 있음.

 */

class Test2{
    static int cv = 10; //10으로 초기화
    static int cv2; //default값 0
    int iv = 9; //초기화 - 초기화를 하지 않아도 사용하는데에는 문제 없다

    //1.static 자원 초기화 블럭 - static 멤버 필드 초기화
    static{
        //이 블럭은 자동으로 실행 : cv와 cv2가 메무리에 올라간 직후 자동으로 실행되는 블럭
        cv = 1111;
        System.out.println("static 초기자 블럭 실행");
        //조작된 값 (cv2 = cv1 + 100), 논리적인 제어가 필요할때 사용
    }

    //2.일반 멤버 필드 초기화 블럭 : 보통 초기화는 생성자가 담당
    {
        //실행 시점 : int iv = 9 가 힙 메모리에 올라간 직후 블록이 자동으로 실행
        //조작된 표현이 필요할때 사용
        System.out.println("초기화 블록 실행");
        if(iv<10) iv = 100000;
    }

    //생성자 함수
    Test2(){
        System.out.println("default 생성자 함수");
    }
}

public class Ex07_Static_Init {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
//        System.out.println(test2.cv);
//        System.out.println(test2.cv2);
//        System.out.println(test2.iv);
    }
}
