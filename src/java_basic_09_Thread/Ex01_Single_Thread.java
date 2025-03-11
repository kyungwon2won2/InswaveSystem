package java_basic_09_Thread;
/*
프로그램(ex. 엑셀, 크롬..) > 실행 > 프로세스 > 최소 하나의 Thread(가장 기본적인 동작의 최소 단위/기능)
    > 최소 하나의 stack memory 가 필요하다 > JVM > Thread 하나 생성(Stack memory) > main 함수 할당

    지금까지 > 싱글 프로세스 > 싱글 Thread > main 함수만 실행 > 하나의 stack > 순차적으로

아래 있는 정수는 하나의 stack 메모리에서 순차적으로(LIFO) 실행

 */
public class Ex01_Single_Thread {
    public static void main(String[] args) {
        System.out.println("나 main 일꾼이야");

        worker();
        worker2();
    }

    static void worker(){
        System.out.println("나 1번 일꾼이야");
    }

    static void worker2(){
        System.out.println("나 2번 일꾼이야");
    }
}
