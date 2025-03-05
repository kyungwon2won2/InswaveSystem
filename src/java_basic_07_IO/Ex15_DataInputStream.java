package java_basic_07_IO;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex15_DataInputStream {
    public static void main(String[] args) {
        // 성적 데이터 -> score.txt 저장
        // 정수타입으로 값이 write
        // read 합계 / 평균
        int sum = 0;
        int score = 0;
        FileInputStream fis = null;
        DataInputStream dis = null;

        try{
            fis = new FileInputStream("score.txt");
            dis = new DataInputStream(fis);
            while(true){
                score = dis.readInt();
                System.out.println("score int data: " + score);
                sum += score; // 장점 (int 형으로 바로 read)
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("sum의 결과: " + sum);
        } finally{
            try{
                dis.close();
                fis.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
