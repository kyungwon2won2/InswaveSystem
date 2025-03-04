package java_basic_04_oop.assignment;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    int[] lottoNum;
    int cnt = 1;
    String filePath = "lotto.txt";

    private Scanner scan = new Scanner(System.in);

    public void start() { // 시작 - 메뉴 이동
        createFile(filePath);
        while (true) {
            int choice = showMenu();
            switch (choice) {
                case 1:
                    setNumber();
                    System.out.println();
                    break;
                case 2:
                    setNumberValidate();
                    System.out.println();
                    break;
                case 3:
                    deleteFile(filePath);
                    System.out.println();
                    break;
                case 4:
                    readFile(filePath);
                    break;
                case 5:
                    return;
            }
        }
    }
    // 메뉴이동 끝

    public int showMenu() { // 메뉴 보여주기

        int choice = 0;

        while (true) { //while문과 try-catch로 재귀해결 및 예외처리
            System.out.println("******************************");
            System.out.println("**********         ***********");
            System.out.println("**********  LOTTO  ***********");
            System.out.println("**********         ***********");
            System.out.println("******************************");
            System.out.println("------------------------------");
            System.out.println("--------메뉴를 선택해주세요-------");
            System.out.println("------------------------------");
            System.out.println("     1. 로또 일반 구매");
            System.out.println("     2. 로또 연속번호 제외 구매");
            System.out.println("     3. 번호생성 초기화");
            System.out.println("     4. 생성중인 번호 확인");
            System.out.println("     5. 프로그램 종료");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.print("메뉴 선택 : ");


            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
                    return choice;
                } else {
                    System.out.println("1 ~ 5번 메뉴를 선택해주세요.");
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                System.out.println();
            }
        }
    }
    // 메뉴화면 끝


    public void setNumber() {
        Random r = new Random();
        lottoNum = new int[6];

        // 중복 없는 숫자 생성
        for (int i = 0; i < lottoNum.length; i++) {
            int num;
            boolean isDuplicate;

            do {
                num = r.nextInt(45) + 1; // 1~45 사이의 난수 생성
                isDuplicate = false;

                // 중복 체크
                for (int j = 0; j < i; j++) {
                    if (lottoNum[j] == num) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate); // 중복된 경우 다시 난수 생성

            lottoNum[i] = num;
        }

        // 숫자 정렬
        Arrays.sort(lottoNum);

        // 생성된 번호 출력
        System.out.println("생성된 로또 번호:");
        for (int num : lottoNum) {
            System.out.print(num + " ");
        }
        System.out.println();
        numberSave();
    }
    //번호생성 끝

    // 연속 4자리 검증 번호생성 및 출력
    public void setNumberValidate() {
        Random r = new Random();
        lottoNum = new int[6];

        while (true) {
            // 중복 없는 숫자 생성
            for (int i = 0; i < lottoNum.length; i++) {
                int num;
                boolean isDuplicate;

                do {
                    num = r.nextInt(45) + 1; // 1~45 사이의 난수 생성
                    isDuplicate = false;

                    // 중복 체크
                    for (int j = 0; j < i; j++) {
                        if (lottoNum[j] == num) {
                            isDuplicate = true;
                            break;
                        }
                    }
                } while (isDuplicate); // 중복된 경우 다시 난수 생성

                lottoNum[i] = num;
            }

            // 숫자 정렬
            int[] sorArr = lottoNum.clone();
            Arrays.sort(sorArr);

            // 연속된 숫자가 4개 이상인지 확인
            if (!validateNum(sorArr)) {
                break; // 조건을 만족하면 루프 종료
            }
        }

        // 생성된 번호 출력
        System.out.println("생성된 로또 번호:");
        for (int num : lottoNum) {
            System.out.print(num + " ");
        }
        System.out.println();
        numberSave();
    }
    //번호생성 끝



    //숫자 검증 - 4개숫자 연속 불가
    public boolean validateNum(int[] num) {
        int count = 1; // 연속된 숫자 개수 카운트

        for (int i = 1; i < num.length; i++) {
            if (num[i] == num[i - 1] + 1) { // 이전 숫자보다 1 큰 경우
                count++;
                if (count >= 4) { // 4개 이상 연속된 숫자가 존재하면 true 반환
                    return true;
                }
            } else {
                count = 1; // 연속되지 않으면 카운트 초기화
            }
        }
        return false;
    }
    //숫자 검증 완료

    //로또번호 파일에 입력
    public void numberSave() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath, true);
            fw.write("[로또번호 " + cnt + "회차] : ");
            for (int num : lottoNum) {
                fw.write(num + " ");
            }
            cnt++;
            fw.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //로또 번호 파일 생성
    public void createFile(String filePath) {
        try{
            File file = new File(filePath);
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //로또 생성 파일 삭제 - 구매 초기화
    public void deleteFile(String filePath) {
        try{
            File file = new File(filePath);
            if(file.delete()){
                System.out.println("File deleted: " + file.getName());
            }else{
                System.out.println("File not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("번호생성을 초기화하였습니다. 다시 1회차부터 구매합니다.");
        cnt = 1;
    }

    //구매중인 로또번호 확인
    public void readFile(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            System.out.println("[[[[구매중인 번호]]]]");
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
