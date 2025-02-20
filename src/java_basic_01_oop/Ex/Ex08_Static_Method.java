package java_basic_01_oop.Ex;

/*
static member field : 객체간 공유자원
static method : public static void main, public static void run()

1.new 없이(객체 생성없이) 사용 가능
2.많이 사용하기 때문에 편하고 빠르게 쓰라고 사용. -> new 없이 빠르게 사용
3.자원을 많이 사용 -> 편하게 사용 -> new 없이 static 사용
 */

class StaticClass {
    int iv;

    static int cv;

    static void print(){
        System.out.println("static print cv : " + cv);
    }

    void printIv(){
        System.out.println("일반 함수");
        //일반함수 -> static 자원과 일반 자원 모두 접근 가능
        //static 함수 -> static 자원만을 접근 가능 - 생성시점의 차이 때문에
    }
}

public class Ex08_Static_Method {
    public static void main(String[] args){
        //메모리에 올라가있음 - class area에...new 없이
        StaticClass.cv = 5555;
        StaticClass.print();

        //일반자원 - heap 메모리에 올려야함
        StaticClass sc = new StaticClass();
        System.out.println(sc.iv);
        sc.printIv();
    }
}
