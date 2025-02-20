package java_basic_01_oop.assignment.ATM;

import java.util.Scanner;

public class Menu {

    public void inputMenu(){
        System.out.println("입력기능\n");

    }

    public void delete(){
        System.out.println("삭제\n");

    }
    public void sort(){
        System.out.println("정렬\n");

    }
    public int printMenu(){
        System.out.println("************");
        System.out.println("***성적관리***");
        System.out.println("1.학생성적 입력");
        System.out.println();
        System.out.println("2.학생성적 삭제");
        System.out.println();
        System.out.println("3.학생성적 이름순 정렬");
        System.out.println();
        System.out.println("4.프로그램 종료");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        if (! (choice <= 4 && choice >= 1) ) {
            System.out.println("잘못된 값입니다. 1과 4 사이의 값을 입력해주세요.\n");
            choice = printMenu();
        }
        return choice;


    }

    public void controlMenu(int num2) {
        int num = num2;
        while (true) {
            switch (num) {
                case 1:
                    inputMenu();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    sort();
                    break;
                case 4:
                    return;
            }
            num = printMenu();
        }
    }


}