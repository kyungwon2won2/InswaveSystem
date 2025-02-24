package java_basic_04_oop;

class Pbase{
    int p = 100;
}

class Cbase extends Pbase{
    int c = 200;
}

class Dbase extends Pbase{

}
public class Ex11_Inherit_poly {
    public static void main(String[] args) {
        //상속관계에서 부모타입의 참조변수는 여러개의 자식타입 주소를 가질 수 있다. (자바의 다형성)
        Cbase cbase = new Cbase();
        System.out.println(cbase.toString());

        //다형성
        Pbase pbase = cbase;
        System.out.println(pbase.toString());

        Dbase dbase = new Dbase();
        pbase = dbase; //부모님은 큰아들도 품고 작은아들도 품을 수 있다.

        System.out.println(pbase.toString());
        ////////////////////////////////////////////////

        Dbase ddd = (Dbase) pbase; //같은주소인데 부모타입이 더 크다고 인식됨... (그 자식에 맞게 캐스팅해야함 - Down Casting)
    }
}
