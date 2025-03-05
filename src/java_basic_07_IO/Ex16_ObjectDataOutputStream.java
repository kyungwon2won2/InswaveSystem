package java_basic_07_IO;

import java_basic_07_IO.kr.or.kosa.UserInfo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
객체 통신
객체(Car, Tv, Tank) > 프로세스, 네트워크, 파일 간 통신 -> 통신을 위해 하나씩 뜯어서 정렬하는 직렬화, 반대의 역직렬화

직렬화 : 객체를 분해해서 줄을 세워 보내는 과정
역직렬화 : 분해된 객체를 다시 조립하는 과정

모든 class 직렬화 가능x
직렬화 가능 게품(레고블럭 처럼)  - implements Serializable 를 달고있는...
class Tank implements Serializable
 */
public class Ex16_ObjectDataOutputStream{
    public static void main(String[] args) {
        //객체를 write 하고 read 할 대상 : 파일
        //UserData.txt 파일에 객체를 write > byte

        String fileName = "UserData.txt"; //에 객체 write
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null; //3총사...ㅋ //직렬화를 사용하기위한 객체

        try{
            fos = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(fos);
            //완제품(객체)를 직렬화해서 write
            oos = new ObjectOutputStream(bos);

            //객체생성
            UserInfo u1 = new UserInfo("홍길동", "super", 100);
            UserInfo u2 = new UserInfo("scott", "tiger", 50);

            //파일에 write ... 직렬화 (줄을 세워서 write)
            oos.writeObject(u1);
            oos.writeObject(u2);
            //끝
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                oos.close();
                bos.close();
                fos.close();
                System.out.println("파일생성 -> buffer -> Object -> 직렬화 -> 파일 write");
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }


    }
}
