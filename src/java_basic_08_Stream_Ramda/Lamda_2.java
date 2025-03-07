package java_basic_08_Stream_Ramda;

public class Lamda_2 {
    public static void main(String[] args) {

        //함수적 인터페이스의 가장 대표적인 녀석이 Thread Runnable 인터페이스

        //익명 클래스 형식
        Runnable run = new Runnable() { //익명 타입으로 사용가능
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        run.run();

        //람다 형식
        Runnable run2 = () -> System.out.println("run2");
        run2.run();
    }
}
