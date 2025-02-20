package java_basic_01_oop.src;

/*
책은 책이름, 가격정보를 가지고있다.
책은 출판되면 반드시 책이름과 가격정보를 가지고있어야한다.
책이름과 가격정보는 특정기능을 통해서만 볼 수 있고, 출판 이후에는 수정할 수 없다.(책가격, 이름)
책이름과 가격정보는 각각 확인가능하다.
 */
public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void printBookData(){
        System.out.println("책이름: " + name + "  가격: " + price);
    }

    public void printBookName(){
        System.out.println("책이름: " + name);
    }

    public void printBookPrice(){
        System.out.println("책가격: " + price);
    }
}
