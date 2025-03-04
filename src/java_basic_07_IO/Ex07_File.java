package java_basic_07_IO;
/*
파일, 폴더를 다루는 클래스

JAVA : File 클래스 -> 파일 생성/삭제/.. 폴더 생성/삭제/..) 하나의 클래스
>> a.txt 생성/수정/삭제/읽기
>> Temp 디렉토리 생성/수정/삭제/읽기

경로
절대경로 : C:\\ , D:\\    -->   D:\\Temp\\a.txt
상대결로 : 현재 파일을 중심으로 > ../   ,   /
 */

import java.io.File;

public class Ex07_File {
    public static void main(String[] args) {
        String path = "C:\\Temp\\file.txt";
//        String path = "data.txt";

        File file = new File(path);
        //이렇게하면 File 객체가 생성될때 .. file에 대한 정보를 분석할 수 있다.
        System.out.println("파일의 존재여부 확인: " + file.exists());
        System.out.println("너 폴더니?: " + file.isDirectory());
        System.out.println("너 파일이니?: " + file.isFile());

        System.out.println("파일명: " + file.getName());
        System.out.println("절대경로: " + file.getAbsolutePath());

        System.out.println("파일크기: " + file.length() + "byte");
        System.out.println("부모경로: " + file.getParent());
    }
}
