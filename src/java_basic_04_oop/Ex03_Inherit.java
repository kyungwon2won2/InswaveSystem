package java_basic_04_oop;

class Tv{
    boolean power;
    int ch;

    void power(){
        this.power = !this.power;
    }

    void chUp(){
        this.ch++;
    }

    void chDown(){
        this.ch--;
    }
}

class  Vcr{
    boolean power;

    void power(){
        this.power = !power;
    }

    void play(){
        System.out.println("재생하기");
    }

    void stop(){
        System.out.println("정지하기");
    }
    void rew(){}
    void ff(){}
}
/*
설계도 2장
class Tv
class Vcr

제품 - tv와 vcr이 합려진 제품 -> TvVcr 출시
다중상속 금지 - 하나를 상속하고 하나는 포함으로 하고싶다(메인기능 주요)  or  둘다 포함으로 하고싶다.
 */
class TvVcr{
    Tv tv;
    Vcr vcr;

    TvVcr(){
        this.tv = new Tv();
        this.vcr = new Vcr();
    }
}

class TvVcr2 extends Tv{
    Vcr vcr;

    TvVcr2(){
        this.vcr = new Vcr();
    }
}

public class Ex03_Inherit {
    public static void main(String[] args) {
        TvVcr tvVcr = new TvVcr();
        tvVcr.tv.power();
        tvVcr.vcr.power();
        tvVcr.vcr.play();
        tvVcr.vcr.stop();
        //////////////////////////////////////
        TvVcr2 tvVcr2 = new TvVcr2();
        tvVcr2.power(); //Tv 메인기능
        tvVcr2.vcr.power(); //Vcr 부가기능
    }
}
