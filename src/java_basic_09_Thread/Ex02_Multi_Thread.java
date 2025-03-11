package java_basic_09_Thread;
/*
Thread : 프로세스에서 현재 실행되고 있는 프로그램을 처리하는 최소 기능 단위 >> method >> 실행되는 공간(memory) > stack
목적 : stack 열개 생성해서 > 동시에 함수를 실행(사실은 이건 틀린말 -> 실행 가능한 상태로 만든다.) > CPU 점유할 수 있는 상태로 만든다.

Multi Thread
-> 여러개의 stack 을 만들자
JAVA API

Thread 생성 (여러개의 stack) 방법 2가지
1. Thread 클래스 제공 상송 : class Task extends Thread >> run 함수 구현
2. Runnable 인터페이스 제공 > class Task2 implements Runnable > run 추상함수 구현
>> Runnable 은 단지 Thread 동작하기 위한 run 을 강제구현하게 만드는 약속..
>> 사용 : Thread tread = new Thread(new Task2());

그럼 왜 굳이 runnable 을 만들었을까??
class Task extends Car implements Runnable
 */
class Task extends Thread{ // Thread 는 추상클래스가 아니고 일반 클래스
    //반드시 run 을 구현해야함.
    @Override
    public void run(){ // run 함수의 역할 : 함수는 새로 생성된 Thread 의 main 함수 역할 >> 새롭게 생성된 stack 에 처음 올라가서 실행되는 함수
        //main 함수 처럼 생각하고 함수 처리
        for(int i = 0; i < 1000; i++){
            System.out.println("Task : " + i + this.getName()); // 내붝으로 생성된 Thread 이름 (getName())
        }
        System.out.println("Task run 함수 END");
    }
}

class Task2 implements Runnable{  //Runnable 은 Thread 가 아니다 > 그냥 run() 만 구현
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.println("Task2 : " + i);
        }
        System.out.println("Task2 run 함수 END");
    }

}


public class Ex02_Multi_Thread { //JVM > stack 생성 > main 너가 사용해
    public static void main(String[] args) { //main 도 하나의 Thread
        Task task = new Task();
        task.start(); // 동작하면 메모리에 새로운 stack 이 생기고, 새로만들어진 stack 에 run 함수 올라감.
        // POINT : start() : memory 새로운 stack 을 생성하고, 그 stack > run() > start() 소멸

        for(int i = 0; i < 1000; i++){
            System.out.println("Main Tread : " + i);
        }
        System.out.println("main() 함수 END");

        ///////////////////////////////////////////////
        Task2 task2 = new Task2();
        Thread thread = new Thread(task2);
        thread.start(); // 3개의 Thread

        //람다식 (함수적 인터페이스) > 대포적인게 Runnable
        //익명클래스 > 람다
        		/*
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("thread2 : " + i);
				}
				System.out.println("thread2  함수 END");

			}
		});
		*/
        //람다식
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("thread2 : " + i);
            }
            System.out.println("thread2  함수 END");
        });

        thread2.start();
    }
    // main 이 끝나도 stack 이 모두 작업이 끝나야 프로그램 종료
}
