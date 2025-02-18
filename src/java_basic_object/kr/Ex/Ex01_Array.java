package java_basic_object.kr.Ex;
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

    }
}
