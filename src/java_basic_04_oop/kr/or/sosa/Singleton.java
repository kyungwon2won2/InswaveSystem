package java_basic_04_oop.kr.or.sosa;
/*
디자인패턴(생성에 관련된 이야기) -> new
어떤것을 보장 받을 것인가 생성에 관련돼서...

싱글톤 : 하나의 객체를 만들어 공유 (공유 -> 객체간 공유자원인 static)
의도 : 하나의 객체를 공유하는 코드를 만들어 사용
공유프린터, 공유IP, ...

못하게 하는것! -> 개발자가 new 하는것을 막고 ... 같은 주소를 공유하게..
Singleton s1 = new Singleton();
Singleton s2 = new Singleton();
Singleton s3 = new Singleton();
 */
public class Singleton {
    private static Singleton p; //현재 null - 초기화하지 않았기때문에
//    public Singleton(){}
    private Singleton() {
        // 생성자 접근자 private >> 생성자를 호출하지 못하게 >> new 하지 못한다.
    }
    //new를 통해서 메모리에 올리지 못하면 -> 다른방법 : static
    public static Singleton getInstance() {
//        return new Singleton(); //클래스 내부에서는 private과 public을 구별하지 않기때문에 가능한..
        //한번만 new를 하게 하려면..
        if(p == null){
            p = new Singleton();
        }
        return p; // 항상 같은 주소의 메모리를 사용함을 보장.
    }
}
