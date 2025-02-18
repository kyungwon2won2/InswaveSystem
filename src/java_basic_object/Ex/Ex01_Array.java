package java_basic_object.Ex;
/*
배열은 객체다
1.new를 통해서 생성
2.heap 메모리 생성 - 관리되는 자원 : GC
3.정적배열(고정배열) : 배열은 한번 선언되면 (크키가 정해지면) 변경 불가 <-> 동적(Collection : JAVA API)
4.자료구조(알고리즘) : 제어문 + 배열 -> 기초적인 초급 자료구조 완성
 */
public class Ex01_Array {
    public static void main(String[] args) {
        //같은 타입의 변수를 여러개 선언해서 사용하는 것은 관리하기 불편. -> 연속된 공간에 나열시켜서 접근, 사용
        //배열
        int[] score = new int[5]; //heap 메모리에 만들어야하기 때문에 new를 써서 생성
        //heap 메모리에 int 방을 5개 >> 연속된 공간 >> [0][1][2][3][4] >> index
        System.out.println(score[0]);
        score[0] = 100;
        score[1] = 200;
        score[2] = 300;
        score[3] = 400;
        score[4] = 500;

        //배열은 객체다 (new heap)
        int[] arr4; //null 값. 메모리를 가지고 있지 않음
        arr4 = new int[] {1,2,3,4,5};

        int[] arr5 = arr4; // 주소값 할당
        //같은 메모리를 보고있음.
        //arr4==arr5 -> true : 같은 주소값을 가지고있음.

        //배열을 만들 수 있는 타입 : 8가지 + 1가지(String) + 클래스
        char[] carr = {'a', 'B', 'c'};

        String[] strarr = new String[] { "가", "가나", "가나다"};
        for (int i=0; i< strarr.length; i++){
            System.out.println(strarr[i]);
        }

        //객체배열 - 그림으로 이해
        Car[] cararr = new Car[3];
        cararr[0] = new Car();
        cararr[1] = new Car();
        cararr[2] = new Car();

    }
}

class Car{

}
