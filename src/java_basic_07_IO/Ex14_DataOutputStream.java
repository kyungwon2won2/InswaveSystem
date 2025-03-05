package java_basic_07_IO;
/*
보조 스트림
DataOutputStream
DataInputStream

장점)
JAVA 가 지원하는 8가지 기본 타입별로 write, read
단 조건은 DataOutputStream >> DataInputStream 으로 사용해야한다.

성적.txt > DB가 아니기 때문에 규칙정의 필요 (. 한줄 enter)
20250606,100,99,50,60
20250607,100,99,50,60
기준점이 있으면 split 을 사용해서 형변환 ... Line 단위 read > split > 타입변환(정수형) ... 처리
-> 이게(문자열을 잘라서 형변환하고 조합하고...) 싫으면 DataOutputStream 을 사용
---------------------------------------------------------------------------
숫자 형태로 : 100,90,50,60
 */

import java.io.*;

public class Ex14_DataOutputStream {
    public static void main(String[] args) {
        int[] score = {100,60,55,95,50};
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try{
            fos = new FileOutputStream("score.txt");
            dos = new DataOutputStream(fos);
            for(int i=0; i<score.length; i++) {
                dos.writeInt(score[i]); //정수값을 그대로 파일에 write
                //조건 : byte 값을 사용하기 때문에 stream을 사용해야함
                //DataInputStream 으로 read 가능
            }
        } catch (Exception e) {
            try {
                dos.close();
                fos.close();
            } catch (IOException ex) {
                e.printStackTrace();
            }
        }
    }
}
