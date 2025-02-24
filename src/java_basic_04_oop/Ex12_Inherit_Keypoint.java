package java_basic_04_oop;
/*
-요구사항-
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다.
A라는 전자제품 매장이 오픈되면
[클라이언트 요구사항]
가전제품은 제품의 가격, 제품의 포인트 정보를 모든 제품이 가지고 있어야합니다.
각각의 전자제품은 제품별 고유한 이름정보를 가지고있다.
각각의 전자제품은 다른 가격정보를 가지고 있다.
제품의 포인트는 가격의 10%를 적용한다.

시뮬레이션 시나리오
구매자 : 제품을 구매하기 위한 금액정보, 포인트 정보를 가지고 있다.

구매자는 제품을 구매할 수 있다, 구매행위를 하게되면 가지고 있는 돈 제품의 가격만큼 감소하고 포인트는 증가한다.
구매는 처음 초기 금액을 가질 수도 있고 입력받을 수도 있다.
 */
class Product{
    int price;
    int bonusPoint;

    Product(int price){
        this.price = price;
        this.bonusPoint = (int)(this.price/10.0);
    }
}

class KtTv extends Product{
    KtTv(){
        super(500);
    }
    //자신만의 고유한 이름

    @Override
    public String toString() {
        return "KtTv";
    }
}

class Audio extends Product{
    Audio(){
        super(100);
    }
    //자신만의 고유한 이름

    @Override
    public String toString() {
        return "Audio";
    }
}

class NoteBook extends Product{
    NoteBook(){
        super(1000);
    }
    //자신만의 고유한 이름

    @Override
    public String toString() {
        return "NoteBook";
    }
}

//리팩토링 전..문제 발생 코드
/*
class Buyer{ //구매행위 ... 검증... 물건구매
    int money = 5000;
    int bonusPoint;

    //구매 기능
    //3개의 제품 구매기능
    void KtTvBuy(KtTv ktTv){ //kttv를 받아야 가격과 이름을 알 수 있다.
        //잔액이 부족
        if(this.money < ktTv.price){
            System.out.println("고객님 잔액이 부족합니다..ㅎㅎ " + this.money);
            return; //함수의 종료
        }
        //실제 구매
        this.money -= ktTv.price;
        this.bonusPoint += ktTv.bonusPoint;
        System.out.println("현재 작액 : " + this.money);
        System.out.println("구매한 물건 : " + ktTv.toString());

    }

    void AudioBuy(Audio audio){ //kttv를 받아야 가격과 이름을 알 수 있다.
        //잔액이 부족
        if(this.money < audio.price){
            System.out.println("고객님 잔액이 부족합니다..ㅎㅎ " + this.money);
            return; //함수의 종료
        }
        //실제 구매
        this.money -= audio.price;
        this.bonusPoint += audio.bonusPoint;
        System.out.println("현재 작액 : " + this.money);
        System.out.println("구매한 물건 : " + audio.toString());

    }

    void NoteBookBuy(NoteBook noteBook){ //kttv를 받아야 가격과 이름을 알 수 있다.
        //잔액이 부족
        if(this.money < noteBook.price){
            System.out.println("고객님 잔액이 부족합니다..ㅎㅎ " + this.money);
            return; //함수의 종료
        }
        //실제 구매
        this.money -= noteBook.price;
        this.bonusPoint += noteBook.bonusPoint;
        System.out.println("현재 작액 : " + this.money);
        System.out.println("구매한 물건 : " + noteBook.toString());

    }
}
*/

// 리팩토링..
class Buyer{ //구매행위 ... 검증... 물건구매
    int money = 5000;
    int bonusPoint;

    //구매 기능
    //3개의 제품 구매기능
    //************다형성*****************
    void buy(Product p){ //kttv를 받아야 가격과 이름을 알 수 있다.
        //잔액이 부족
        if(this.money < p.price){
            System.out.println("고객님 잔액이 부족합니다..ㅎㅎ " + this.money);
            return; //함수의 종료
        }
        //실제 구매
        this.money -= p.price;
        this.bonusPoint += p.bonusPoint;
        System.out.println("현재 작액 : " + this.money);
        System.out.println("구매한 물건 : " + p.toString());

    }
}
public class Ex12_Inherit_Keypoint {
    public static void main(String[] args) {
        //가오픈 ...  매장 제품 배치(메모리)
        KtTv ktTv = new KtTv();
        Audio audio = new Audio();
        NoteBook noteBook = new NoteBook();

        Buyer buyer = new Buyer();

        //오버로딩과 다형성을 이용하여 코드 감소, 생산성 향상
        buyer.buy(ktTv);
        buyer.buy(ktTv);
        buyer.buy(audio);
        buyer.buy(noteBook);
        buyer.buy(noteBook);
        buyer.buy(noteBook);
        buyer.buy(ktTv);
        buyer.buy(ktTv);
    }
}
/*
1차 오픈
매장 >> 하와이 휴가 ... 1주일
매장에 재품 10000개 제품 추가(마우스, 토스트기, 청소기) POS 시스템(제춤 자동등록)
매장에 1000개 제품 전시

전단지, 인터넷 홍보  오픈세일..

1.하와이 해변 ... 개똥이 ... 핸드폰 울리기 시작...
>> 문제발생 >> 물건이 3개 제품밖에 구매가 안된다. 997개 제품은 구매가 안된다. >> 997개 구매함수를 만듦...

>> 문제해결 >> 구매를 함수 하나로 통합해야함 >> 모든 제품은 부모가 Product
Product = new Audio();
product = new NoteBool(); 을 받을 수 있다.

단, 조건 : 모든 전자제품은 Product를 상속해야만 구매가 가능하다.
 */
