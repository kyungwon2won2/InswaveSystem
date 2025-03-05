package java_basic_07_IO.Quiz;

//도서 관리자 클래스

import java.io.*;
import java.util.HashMap;

import java.util.Scanner;
import java.util.Set;

public class BookManager {

    Scanner scan = new Scanner(System.in);

    HashMap<String, Book> book_dic = new HashMap<String, Book>();

    public void Run() {

        int key = 0;

        while ((key = selectMenu()) != 0) {

            switch (key) {

                case 1:
                    addBook();
                    break;

                case 2:
                    removeBook();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    listBook();
                    break;

                case 5:
                    listISBN();
                    break;

                case 6:
                    saveBook();
                    break;

                case 7:
                    loadBook();
                    break;

                default:
                    System.out.println("잘못 선택하였습니다.");
                    break;

            }

        }

        System.out.println("종료합니다...");

    }

    int selectMenu() {

        System.out.println("1:추가 2:삭제 3:검색 4:도서 추가 목록 5:ISBN 목록 6:저장 7:도서 로드 0:종료");

        int key = scan.nextInt();

        scan.nextLine();

        return key;

    }

    void addBook() {

        String isbn;

        System.out.print("추가할 도서 ISBN:");

        isbn = scan.nextLine();

        if (book_dic.containsKey(isbn)) {

            System.out.println("이미 존재하는 ISBN입니다.");

            return;

        }

        String title;

        int price;

        System.out.print("도서 제목:");

        title = scan.nextLine();

        System.out.print("가격:");

        price = scan.nextInt();

        scan.nextLine();

        Book book = new Book(isbn, title, price);

        book_dic.put(isbn, book);

        System.out.println(book.toString() + " 생성하였습니다.");
    }

    void saveBook() {
        File file = new File("book.txt");

        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            oos.writeObject(book_dic); // 직렬화

            oos.close();
            bos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("도서 저장에 실패했습니다.");
            e.printStackTrace();
        }
        System.out.println("도서를 저장하였습니다.");
    }

    void removeBook() {

        String isbn;

        System.out.print("삭제할 도서 ISBN:");

        isbn = scan.nextLine();

        if (book_dic.containsKey(isbn)) {

            book_dic.remove(isbn);

            System.out.println("삭제하였습니다.");

        }

        else {

            System.out.println("존재하지 않습니다.");

        }

    }

    void searchBook() {

        String isbn;

        System.out.print("검색할 도서 ISBN:");

        isbn = scan.nextLine();

        if (book_dic.containsKey(isbn)) {

            Book book = book_dic.get(isbn);
            System.out.println("검색 결과>>" + book.toString());

        }

        else {

            System.out.println("존재하지 않습니다.");

        }

    }

    void listBook() {

        System.out.println("도서 목록");

        int cnt = book_dic.size();

        System.out.println("도서 수:" + cnt);

        for (Book book : book_dic.values()) {

            System.out.println(book.toString());

        }

    }

    void listISBN() {

        System.out.println("ISBN 목록");

        int cnt = book_dic.size();

        System.out.println("도서 수:" + cnt);

        for (String isbn : book_dic.keySet()) {

            System.out.println(isbn);

        }

    }

    void loadBook() {
        File file = new File("book.txt");
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            book_dic = (HashMap<String, Book>) ois.readObject();
            Set<String> set = book_dic.keySet();
            System.out.println("ISBN\t\t제목\t\t가격");
            for (String isbn : set) {
                String title = book_dic.get(isbn).title;
                int price = book_dic.get(isbn).price;
                System.out.printf("%s\t%s\t%d\n", isbn, title, price);
            }
            ois.close();
            bis.close();
            fis.close();
        } catch (Exception e){
            System.out.println("불러오기에 실패했습니다.");
            System.out.println(e.getMessage());
        }

    }

}