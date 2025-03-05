package java_basic_07_IO;

import java.io.*;

/*
출력 형식을 지정
1.printf
2.String.format
3.I/O PrintWriter (파일에 출력 이쁘게..)

출력물) 웹 (html 그려서) 세금계산서, 지출결의서, 휴가동의서 >> 레포팅 전용 툴 > 오즈, 크리스탈 레포트

console 기반 -> PrintWriter 로 출력
 */
public class Ex12_PrintWriter {
    public static void main(String[] args) {
        try {
            //파일 생성하고 쓰기작업//
//            PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
//            pw.println("**************************************");
//            pw.println("**************HOMEWORK****************");
//            pw.printf("%3s : %5d  %5d  %5d  %5.1f", "홍길동", 100, 90, 80, (float)(90+80+100)/3);
//            pw.println();
//            pw.close();

            //파일 읽기작업 (엔터를 기준으로 Line 단위로 읽음)//
            //-> Buffer 이용(한 줄씩..)
            FileReader fr = new FileReader("C:\\Temp\\homework.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            br.close();
            fr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
