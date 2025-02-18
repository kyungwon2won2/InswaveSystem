package java_basic_oop.Ex;

import java_basic_oop.src.Emp;
import java_basic_oop.src.Mouse;
import java_basic_oop.src.NoteBook;

public class Ex04_Modifider {

    public static void main(String[] args) {

        NoteBook noteBook = new NoteBook();
        noteBook.printNoteBookInfo();

        noteBook.setYear(2025);
        noteBook.setColor("black");
        noteBook.printNoteBookInfo();

        //마우스 (구매)
        Mouse mouse = new Mouse();
        //String mouseData= mouse.getReadMouseData();
        //System.out.println(mouseData);

        //마우스 사용 (noteBook)
        noteBook.handleMouse(mouse); //주소값 전달



        Emp emp = new Emp();
        emp.setEverything(2000, "홍길동", 1000, "IT");
        emp.printEmpInfo();


    }



}
