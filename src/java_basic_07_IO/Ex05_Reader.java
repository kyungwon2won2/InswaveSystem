package java_basic_07_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
문자 기반의 데이터 처리 (char[] 을 다룬다고 생각)
String 클래스 > 내부적으로 데이터 처리는 char[] 이다.

Reader  ,  Writer  (추상 클래스)

파일)
FileReader  ,  FileWriter
 */
public class Ex05_Reader {
    public static void main(String[] args) {
        FileReader fr = null; //밖에서 close 처리를 위해 이렇게한다..
        FileWriter fw = null;

        try {
            fr = new FileReader("Ex01_Stream.java"); //read
            fw = new FileWriter("copy_Ex01.txt"); //이 경로(현재:default)에 이 파일이 없으면 create ..
            int data = 0;
            while((data = fr.read()) != -1) {
//                System.out.println((char)data);
//                fw.write(data); // 한 문자씩 write
                if(data != '\n' && data != '\r' && data != '\t' && data != ' '){
                    fw.write(data);
                } // 압축 -> 엔터와 공백 없이.. (파일에 특정 문자 제거)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
