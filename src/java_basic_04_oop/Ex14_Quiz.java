package java_basic_04_oop;
//System 클래스
//out 클래스
//println
// 을 구현해 보세요
class MySystem{
    static final Print out;
    static {
        out = new Print();
    };
}

class Print{
    void add(int i) {
        System.out.println(i);
    }
    void add(String s){
        System.out.println(s);
    }
}

public class Ex14_Quiz {
    public static void main(String[] args) {
        MySystem.out.add(100);

        System.out.println();
        /*
         System.out.println() 를 까보면....
         public static final PrintStream out;
         static{
            out = new PrintStream;
         }
         */
    }
}
