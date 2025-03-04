package java_basic_07_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex06_Reader_Writer_Buffer {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader("Ex01_Stream.java");
            br = new BufferedReader(fr);
            //line 단위로 read, write
            String line = null;
            while((line = br.readLine()) != null) {
//                System.out.println(line);
                if(line.indexOf(";") != -1){ //';' 이 포함된 문장만 출력
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
                                         I/O
                                   /             \
                         byte[]                   char[]
                           /        \           /        \
                 InputStream    OutputStream   Reader    writer
 대상 파일 : FileInputStream  FileOutputStream FileReder  FileWriter
 + Buffer  ->
 */
