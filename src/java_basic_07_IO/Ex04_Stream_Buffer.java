package java_basic_07_IO;
/*
Buffer - buffer 를 쓰는것을 권유.
File처리 >> Disk >> 입출력 단위 Byte 씩

여러명 학생 한명씩 목적지에 보내는 곳이 아니고, 여러명이 탈 수 있는 버스를 대여해서 버스에 태워서 보내고 처리하겠다.
-> Buffer (버스)
1. I/O 성능 개선(접근 횟수 줄어든다)
2. Line 단위 처리 가능(엔터)
------------------------------------------------------------------------------------------------
JAVA I/O 보조 Stream

BufferedOutputStream > 독자적인 작업 불가
BufferedInputStream bf = new BufferedInputStream(InputStream) > File (input) Stream 주소 ...
------------------------------------------------------------------------------------------------
웹서버 WAS
-> 데이터 처리를 위해 Buffer 사용 (8 kbyte)

1.Buffer 안에 요청한 페이지의 내용을 채우는데.. 내용을 다 채우면 자동으로 출발(8 kbyte)
    ->학생3명 ..... 버스 출발기준이 채워져야만 출발가능한가? : flush() 로 해결... 사실은 close()가 flush()를 내포.
    ->명시적으로 flush() 해주지 않아도된다.
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_Stream_Buffer {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream("data.txt"); //파일이 없으면 create
            bos = new BufferedOutputStream(fos); //버스 생성

            for(int i=0; i<10; i++) {
                bos.write('A'); //data.txt 에 buffer 에 다 태워서 한번에 보내겠다.
            }
//            bos.flush(); // close()에 flush()가 내포되어있어서 안써줘도됨.
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
