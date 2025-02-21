package java_basic_04_oop.kr.or.sosa;
/*
새 (공통 : 일반,추상) :새는 날 수 있다. 새는 빠르다.
 */
public class Bird {
    //공통기능
    public void fly(){
        System.out.println("flying");
    }
    //설계자 고민 - 모든 새가 moveFast할때 fly하는 것은 아니다....
//    public void moveFast(){
//        fly();
//    }
    protected void moveFast(){
        fly();
    }
}
