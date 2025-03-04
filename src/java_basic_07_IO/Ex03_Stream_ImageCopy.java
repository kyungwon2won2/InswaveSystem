package java_basic_07_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_Stream_ImageCopy {
    public static void main(String[] args) {
        String oriFile = "C:\\Temp\\copy.jpg";
        String targetFile = "copy2.jpg"; //경로를 안쓰고 파일명만 쓰면 : default 경로 
                                        // -> C:\Users\Yeo\Desktop\InswaveSystem\src\ (프로젝트 파일 위치)

        FileInputStream fs = null;
        FileOutputStream fos = null;
        
        try{
            fs = new FileInputStream(oriFile);
            fos = new FileOutputStream(targetFile); //출력의 대상이 "copy2.jpg"
            //만약 write시 파일이 없다면 파일생성 (FileCreate)
            int data = 0; // 1 byte 씩 데이터를 저장
            while((data = fs.read()) != -1) { //read()는 파일 끝에 도달하면 -1을 반환 -> 파일 끝까지 읽는다.
                fos.write(data); //생성된 copy2.jpg에 값을 write
            }
        } catch (Exception e) {
            e.printStackTrace(); //에러를 상세하게 출력해주는 메서드
        } finally {
            try {
                fos.close();
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
