package java_basic_07_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex02_FileStream {
    /*
        Today Point
        Byte 데이터  read / write 대상이 > File(a.txt , data.txt)

        FileInputStream
        FileOutputStream

        이미지 (a.jpg) , 엑셀 (POI lib ) , 1.txt (파일)

        I/O 자원은 개발자 직접적으로 그 자원에 해제 (워드 파일 편집 -> 다른 사람 읽기 가능 -> 다른 사람 편집 -> 파일 편집 끝(close)

        >>close() 자원해제
        >>예외가 많이 발생 (강제) 예제를 처리하도록 하는 부분 ( throws 구현된 코드) -> try 예외처리 강제

    */
    public static void main(String[] args) {

        FileInputStream fs = null;
        FileOutputStream fos = null;

        String path = "C:\\Temp\\a.txt";

        try {
            fs = new FileInputStream(path); //C:\\Temp\\a.txt  >> a.txt >> 빨대
            //fos = new FileOutputStream("C:\\Temp\\new.txt");
            fos = new FileOutputStream("C:\\Temp\\new.txt",true);
            //출력 (대상 파일) 현재 Temp 폴더안에 new.txt 없어요
				/*
					FileOutputStream
					1. write  파일이 존재하지 않으면 >> 자동 파일 생성(createFile 기능)

					2. fos = new FileOutputStream("C:\\Temp\\new.txt" ,false);
					   false >> overwrite

					3. fos = new FileOutputStream("C:\\Temp\\new.txt" ,true);
					   true >> append
				*/
            int data=0;
            while((data = fs.read()) != -1) {
                System.out.println("정수(아스키 코드: 십진수) " + data + "문자" + (char)data);
                fos.write(data);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //정상 , 비정상
            //함수가  종료  return
            //블럭은 강제 실행
            //안심하고 자원을 해제 (I/O 자원 GC 관리하지 않아요)
            //close();
            try {

                fos.close();
                fs.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
