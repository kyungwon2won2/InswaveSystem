package java_basic_oop.Ex;

public class Ex09_Static_Method {
    void method(){
        System.out.println("나 일반함수야");
    }

    static void smethod(){
        System.out.println("나 static 함수야.");
    }

    public static void main(String[] args){
        Ex09_Static_Method sm = new Ex09_Static_Method();
        sm.method();

        smethod();
    }
}
