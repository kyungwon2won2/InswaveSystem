package java_basic_01_oop.Ex;

import java_basic_01_oop.src.Book;

public class Ex13_Book {
    public static void main(String[] args) {
        Book b1 = new Book("어린왕자", 20000);
        Book b2 = new Book("전래동화", 15000);

        b1.printBookData();
        b1.printBookName();
        b1.printBookPrice();

        b2.printBookData();
        b2.printBookName();
        b2.printBookPrice();
    }
}
