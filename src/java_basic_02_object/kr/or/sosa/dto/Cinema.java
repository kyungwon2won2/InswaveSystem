package java_basic_02_object.kr.or.sosa.dto;
/*
필수기능
1.좌석 정보를 조회할 수 있다.
2.좌석 예매 가능
3.예매 정보를 조회
4.예매 취소 가능
5.좌석 초기화
+ 영화관에 필요한 기능 추가 2~3가지
 */

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Cinema {
    private String[][] seat = new String[4][5];
    private String revNum;

    private String moiveName = "소방관";

    public int showMenu(){
        System.out.println("***************************");
        System.out.println("*******영화 예매 시스템*******");
        System.out.println("***************************");
        System.out.println("1. 예매하기");
        System.out.println("2. 예매조회");
        System.out.println("3. 예매취소");
        System.out.println("4. 좌석변경");
        System.out.println("5. 예매현황");
        System.out.println("6. 프로그램 종료");

        Scanner scan = new Scanner(System.in);

        int choice = Integer.parseInt(scan.nextLine());
        if (! (choice <= 6 && choice >= 1) ) {
            System.out.println("범위 내의 메뉴를 선택해주세요.\n");
            choice = showMenu();
        }
        return choice;
    }

    public void Menu(int choice) {
        int num = choice;
        while (true) {
            switch (num) {
                case 1:
                    reservation();
                    break;
                case 2:
                    reservationCheck();
                    break;
                case 3:
                    reservationCancel();
                    break;
                case 4:
                    changeSeat();
                    break;
                case 5:
                    revStatus();
                    break;
                case 6:
                    return;
            }
            num = showMenu();
        }
    }

    public void reservation(){
        System.out.println("*******좌석 현황*******");
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                if(seat[i][j] == null) {
                    System.out.printf("[%d-%d]", i + 1, j + 1);
                }else{
                    System.out.print("[예약]");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
        System.out.println("좌석을 선택해주세요.  예)1-1");
        System.out.println("이미 예약된 좌석은 \"예매\"라고 표시됩니다.");

        Scanner scan2 = new Scanner(System.in);
        String choice = scan2.nextLine();
        String[] choiceNum = choice.split("-");
        int row = Integer.parseInt(choiceNum[0])-1;
        int col = Integer.parseInt(choiceNum[1])-1;

        if(row> seat.length || col > seat[row].length){
            System.out.println("없는 좌석번호 입니다. 다시 확인해주세요. 초기화면으로 이동합니다.");
        }

        if(seat[row][col] == null){
            System.out.println("예매 가능합니다. 예매하시겠습니까?");
            System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
            Scanner scan3 = new Scanner(System.in);
            int revChoice = scan2.nextInt();
            if(revChoice == 1){
                revNum = makeRevNum();
                seat[row][col] = String.valueOf(revNum);
                System.out.println("예매가 완료되었습니다");
                System.out.println("예매한 좌석번호:["+(row+1)+"-"+(col+1)+"]/ 예매번호:["+revNum+"]");
                System.out.println("감사합니다");
                System.out.println();
            }
        } else{
            System.out.println("이미 예약된 좌석입니다. 초기화면으로 이동합니다.");
            System.out.println();
        }


    }

    public void reservationCheck(){
        System.out.println("예매번호를 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        revNum = scan.nextLine();
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                if(Objects.equals(seat[i][j], revNum)){
                    System.out.printf("고객님이 예매하신 좌석은 %d-%d입니다.",i+1,j+1);
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public void reservationCancel(){
        System.out.println("예매번호를 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        revNum = scan.nextLine();
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                if(Objects.equals(seat[i][j], revNum)){
                    System.out.printf("예매하신 좌석은 %d-%d입니다.",i+1,j+1);
                    System.out.println("예매를 취소하시겠습니까?");
                    System.out.println("네(1), 아니오(2)중 하나를 입력해주세요.");
                    Scanner scan2 = new Scanner(System.in);
                    int resetNum = scan2.nextInt();
                    if(resetNum == 1){
                        seat[i][j] = null;
                        System.out.println("예매가 취소되었습니다. 감사합니다.");
                        System.out.println();
                    }
                }
            }
        }
    }

    public void resetSeatAll(){
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                seat[i][j] = null;
            }
        }
    }

    public void resetSeat(int i, int j){
        seat[i][j] = null;
    }

    public void changeSeat(){
        System.out.println("예약번호를 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        revNum = scan.nextLine();
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                if(Objects.equals(seat[i][j], revNum)){
                    System.out.printf("현재 고객님이 예매하신 좌석은 %d-%d입니다.",i+1,j+1);
                    System.out.println();
                    System.out.println("*******좌석 현황*******");
                    for(int k=0; k< seat.length; k++){
                        for(int h=0; h<seat[i].length; h++){
                            if(seat[k][h] == null) {
                                System.out.printf("[%d-%d]", k + 1, h + 1);
                            }else{
                                System.out.print("[예약]");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("변경하실 좌석을 선택해주세요.  예)1-1");
                    System.out.println("이미 예약된 좌석은 \"예매\"라고 표시됩니다.");

                    Scanner scan2 = new Scanner(System.in);
                    String choice = scan2.nextLine();
                    String[] choiceNum = choice.split("-");
                    int row = Integer.parseInt(choiceNum[0])-1;
                    int col = Integer.parseInt(choiceNum[1])-1;

                    if(row> seat.length || col > seat[row].length){
                        System.out.println("없는 좌석번호 입니다. 다시 확인해주세요. 초기화면으로 이동합니다.");
                    }

                    if(seat[row][col] == null){
                        System.out.println("변경 가능합니다. 변경하시겠습니까?");
                        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
                        Scanner scan3 = new Scanner(System.in);
                        int revChoice = scan2.nextInt();
                        if(revChoice == 1){
                            seat[row][col] = String.valueOf(revNum);
                            System.out.println("변경이 완료되었습니다");
                            System.out.println("예매한 좌석번호:["+(row+1)+"-"+(col+1)+"]/ 예매번호:["+revNum+"]");
                            System.out.println("감사합니다");
                            System.out.println();
                        }
                        resetSeat(row, col);
                    } else{
                        System.out.println("이미 예약된 좌석입니다. 초기화면으로 이동합니다.");
                        System.out.println();
                    }

                }
            }
        }
    }

    public void revStatus(){
        int cnt = 0;
        System.out.println("영화 제목 : " + moiveName);
        System.out.println("*******예약 현황*******");
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                if(seat[i][j] == null) {
                    System.out.printf("[%d-%d]", i + 1, j + 1);
                }else{
                    System.out.print("[예약]");
                    cnt++;
                }
            }
            System.out.println();
        }
        System.out.println("현재 예약 좌석 수 : " + cnt + "   /  남은 좌석 수 : " + (20-cnt));
    }


    public String makeRevNum(){
        Random r = new Random();
        String ran = "";

        for (int i = 0; i < 10; i++) {
            ran += Integer.toString(r.nextInt(9) + 1 );
        }
        return ran;
    }

}
