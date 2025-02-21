package java_basic_04_oop;

import java_basic_04_oop.kr.or.sosa.Pclass;

/*
-접근자-
private - 캡슐화
default - 같은 폴더 : package
public
상속관계에서 protected

protected의 양면성 - default와 public의 성질을 모두 가지고있음.
>> 상속이 없는 클래스 안에서 protected -> default와 동일  -> default 사용
>> 결국 상속관계에서 의미 > public
 */
class Dclass{
    public int i;
    private  int p;
    int s; //접근자 default
    protected int k; //default -> 일반클래스에서는 굳이 protected를 쓸 필요가 없음
}

class Child2 extends Pclass{ //Pclass 상속관계
    void method(){
        this.k = 100; //상속관계에서 자식은 부모의 protected 자원을 사용 -> public의 의미
        this.i = 200;
    }

    //protected의 진정한 의미(함수) : 상속관계 재정의 통한 사용
    @Override
    protected void m() {
        super.m();
    }
}

public class Ex08_Inherit_Protected {
    public static void main(String[] args) {
        Pclass pclass = new Pclass();
        pclass.i = 100; //public
//        pclass.k;  //상속관계아니면 default 판단(같은 package에서만 사용가능)
        pclass.m2();
//        pclass.m();  //상속이 아니면 default 다른 package 사용불가.
        Child2 c2 = new Child2();
        c2.m();
    }
}
