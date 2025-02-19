package java_basic_object.Ex;

import java.util.Random;

public class Ex09_Array_Cinema {
    public static void main(String[] args) {
        /*
        상영관 좌석배치 - 행과열
         */
        String[][] seat = new String[3][5];
        Random r = new Random();
        String ran = Integer.toString(r.nextInt());

        System.out.println("예매번호 : " + r.nextInt()+1);

        /*
        [][][][][]
        [][][][][]
        [][][][][]
         */
        //좌석 초기화
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                //좌석을 초기화
                seat[i][j]="__"; // 빈 의자 설정
            }
        }

        //09시 오픈 예매
        seat[2][1] = "홍길동";
        seat[0][0] = "김유신";

        for (String[] strings : seat) {
            for (String string : strings) {
                //seat[i][j].equals("__") ? "좌석" : "예매";
                System.out.printf("[%s]", string.equals("__") ? "좌석" : "seat[i][j]");
            }
            System.out.println();
        }

        //예매... 어떤 좌석 선택 (예매 가능 여부 확인)
        int row, col;
        row = 1;
        col = 0;
        if(seat[row][col].equals("__")){
            System.out.println("예매 가능합니다.");
        }else{
            System.out.println("이미 예약되었습니다.");
        }

        // 진행...

        //예매 종료 - 영화시작 -> 관리자입장: 좌석 초기화
        //좌석 초기화
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                //좌석을 초기화
                seat[i][j]="__"; // 빈 의자 설정
                System.out.printf("[%s]", seat[i][j].equals("__") ? "좌석" : "seat[i][j]");
            }
            System.out.println();
        }
    }
}
