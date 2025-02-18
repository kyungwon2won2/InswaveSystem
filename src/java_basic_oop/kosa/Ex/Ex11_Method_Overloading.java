package java_basic_oop.kosa.Ex;
/*
객체지향 프로그래밍 : 여러개의 작은 부품을 만들어서 큰 부품으로 조합하는 행위
여러개의 작은 설계도를 만들어서 조합 -> 하나의 큰 설계도를 만드는 것
>>재사용 가능해야함.

1.상속(재사용성)
2.캡슐화(은닉화) : private > setter > getter - 직접할당을 막고, 간접할당을 통해서 데이터 보호
3.다형성 : 상속관계에서 부모타입의 변수가 여러개의 자식객체의 주소를 가질수 있는 것. > (상속관계에서)하나의 참조변수가 여러개의 주소를 가질 수 있다.

[Method Overloading]
1.하나의 이름으로 여러가지 기능
2.System.out.println() - 이름은 하나 , 기능은 여러개(함수 parameter 개수,타입 다르게)
3.오버로딩은 성능에 관계x, 편하게 쓰기위해 사용

문법>
1.함수의 이름은 같고 parameter의 개수, 타입이 다르게
    -함수의 이름 동일
    -parameter의 개수와 타입을 다르게
    -return타입은 오버로딩의 판단기준이 아니다
    -parameter의 순서가 다른것을 인정
*/

class Human{
    String name;
    int age;
}

class OverClass{
    int add(int i){
        return 100+i;
    }

    int add(int i, int j){
        return i+j;
    }

    String add(String str){
        return "str";
    }

    String add(String s, int i){
        return "hello" + s;
    }

    String add(int i,String s){
        return "hello" + s;
    } //parameter의 순서가 다름을 인정

    void add(Human human){
        human.name = "홍길동";
        human.age = 25;
    }
}

class Test3{
    Human add(Human human){ // human -> 0xab 번지
        Human man = human; // man -> 0xab 번지
        man.name = "아무개";
        man.age = 20;

        return man;
    }

    Human add(Human h1, Human h2){
        h2.name = h1.name;
        h2.age = h1.age;
        return h2;
    }
}

public class Ex11_Method_Overloading {
    public static void main(String[] args) {

        OverClass ov = new OverClass();
        ov.add(10,10);
        ov.add("A");

        Human human01 = new Human();
        ov.add(human01);

        ov.add(new Human());

        Test3 t3 = new Test3();
        Human h3 = new Human(); // h3 -> 0xab 번지
        Human h4 = t3.add(h3); // h4 -> 0xab 번지
        System.out.println(h4.name + " " + h4.age);
    }


}
