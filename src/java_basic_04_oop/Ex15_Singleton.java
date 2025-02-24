package java_basic_04_oop;

import java_basic_04_oop.kr.or.sosa.Singleton;

public class Ex15_Singleton {
    public static void main(String[] args) {
//        Singleton singleton = new Singleton();   -> private
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
        System.out.println(singleton2 == singleton3);
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton3);
    }
}
