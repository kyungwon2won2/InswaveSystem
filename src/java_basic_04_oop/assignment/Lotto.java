package java_basic_04_oop.assignment;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

    int[] lottoNum;

    private Scanner scan = new Scanner(System.in);

    public void start(){ // 시작 - 메뉴 이동

        while(true) {
            int choice = showMenu();
            switch (choice) {
                case 1 :
                    setNumber();
                    break;
                case 2 :
                    return;
            }
        }
    }
    // 메뉴이동 끝

    public int showMenu(){ // 메뉴 보여주기

        int choice = 0;

        while(true) { //while문과 try-catch로 재귀해결 및 예외처리
            System.out.println("******************************");
            System.out.println("**********         ***********");
            System.out.println("**********  LOTTO  ***********");
            System.out.println("**********         ***********");
            System.out.println("******************************");
            System.out.println("------------------------------");
            System.out.println("--------메뉴를 선택해주세요-------");
            System.out.println("------------------------------");
            System.out.println("         1. 로또 구매");
            System.out.println("         2. 종료");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.print("메뉴 선택 : ");


            try {
                choice = Integer.parseInt(scan.nextLine());
            }catch (NumberFormatException e){ // 숫자 입력 검증
                System.out.println("메뉴 범위 내로 입력해주세요.");
            }
        }
        return choice;
    }
    // 메뉴화면 끝

    public int[] setNumber(){
        Random r = new Random();
       lottoNum = new int[7];
        for(int i=0; i<lottoNum.length; i++){
            for(int j=0; j<i; j++){
                if(lottoNum[i] != lottoNum[j]){
                    lottoNum[j] = r.nextInt(45) + 1;
                }else{
                    i--;
                }
            }
        }

        for (int i = 0; i < lottoNum.length; i++) {
            System.out.println(lottoNum[i]);
        }
        return lottoNum;
    }
}
