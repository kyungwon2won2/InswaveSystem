package java_basic_04_oop;
/*
문제 풀어 보세요 ^^
요구사항
 >> 매장카트 구현하기 입니다 <<
카트 (Cart) >> member field
카트 매장에 있는 [모든 전자제품]을 담을 수 있다
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... [카트에 담는다]
---------------------------------------
계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart  담는 것을 구현 )
hint) Buyer ..>> summary()  main 함수에서 계산할때  사용합니다

Buyer >> buy() , summary()  >> 카트에 물건 계산 (어떤물건 , 각 가격 >> 당신은 총 얼마 지급)

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
*/
class Product2 {
    int price;
    int bonusPoint;

    Product2(int price) {
        this.price = price;
        this.bonusPoint = (int) (this.price / 10.0);
    }
}

class KtTv2 extends Product2 {
    KtTv2() {
        super(500);
    }

    @Override
    public String toString() {
        return "KtTv2";
    }
}

class Audio2 extends Product2 {
    Audio2() {
        super(100);
    }

    @Override
    public String toString() {
        return "Audio2";
    }
}

class NoteBook2 extends Product2 {
    NoteBook2() {
        super(1000);
    }

    @Override
    public String toString() {
        return "NoteBook2";
    }
}

class Buyer2 {
    int money = 5000;
    int bonusPoint;
    Product2[] cart;
    int cartIndex = 0;  // 현재 카트에 담긴 상품 개수

    Buyer2() {
        this.cart = new Product2[10]; // 카트 크기 고정
    }

    void buy(Product2 p) {
        if (this.money < p.price) {
            System.out.println("잔액 부족! 현재 잔액: " + this.money);
            return;
        }

        if (cartIndex >= cart.length) {
            System.out.println("카트가 가득 찼습니다!");
            return;
        }

        this.money -= p.price;
        this.bonusPoint += p.bonusPoint;
        this.cart[cartIndex++] = p;

        System.out.println("구매한 물건: " + p);
        System.out.println("현재 카트 내용: " + getCartContents());
    }

    String getCartContents() {
        if (cartIndex == 0) {
            return "카트가 비어 있습니다.";
        }

        StringBuilder cartContents = new StringBuilder();
        for (int i = 0; i < cartIndex; i++) {
            cartContents.append(cart[i]).append(" ");
        }
        return cartContents.toString();
    }


    void summary() {
        int totalCost = 0;
        System.out.println("\n[구매한 물건 목록]");
        for (int i = 0; i < cartIndex; i++) {
            totalCost += cart[i].price;
        }
        System.out.println("총 구매 금액: " + totalCost + "원");
        System.out.println("잔액: " + money + "원");
    }
}

public class Ex13_Inherit_KeyPoint {
    public static void main(String[] args) {
        KtTv2 ktTv = new KtTv2();
        Audio2 audio = new Audio2();
        NoteBook2 noteBook = new NoteBook2();

        Buyer2 buyer = new Buyer2();

        buyer.buy(ktTv);
        buyer.buy(audio);
        buyer.buy(noteBook);
        buyer.buy(noteBook);
        buyer.buy(ktTv);
        buyer.buy(audio);
        buyer.buy(noteBook);
        buyer.buy(audio);
        buyer.buy(audio);
        buyer.buy(audio);
        buyer.buy(audio);

        buyer.summary();
    }
}
