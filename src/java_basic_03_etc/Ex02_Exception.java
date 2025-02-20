package java_basic_03_etc;

public class Ex02_Exception {
    public static void main(String[] args) {

        System.out.println("main start");
        int num = 100;
        int result = 0;

        try{
            for (int i = 0; i < 10; i++) {
                result = num / (int)(Math.random()*10); //0~9까지의 난수 정수로 나눔
                System.out.println("result: " + result + "     i: " + i);
            }
        }catch (ArithmeticException e){  //Exception e 으로 쓰면 가독성이 조금 낮아짐 -> ArithmeticException e 로 가독성을 좋게 해주도록하자.
            System.out.println("문제 발생 > 관리자에게 메일보내요");
            System.out.println("원인 : " + e.getMessage());
        }


        System.out.println("main end");
    }
}
