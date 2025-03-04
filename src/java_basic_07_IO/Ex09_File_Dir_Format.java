package java_basic_07_IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//파일 정보 알아내기
public class Ex09_File_Dir_Format {
    public static void main(String[] args) {
        File dir = new File("C:\\Temp");
        File[] files = dir.listFiles(); //POINT : file 객체 배열 (File 안에 ... 폴더 or 파일)
        for(int i=0; i<files.length; i++){
            File file = files[i];
            //file 이 폴더인지 파일인지 ... 확인해봐야함
            String name = file.getName(); //폴더명 or 파일명
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String attribute = "";
            String size = "";
            if(files[i].isDirectory()){
                attribute = "<DIR>";
            }else {
                //파일 (a.txt 등등)
                size = file.length() + "byte";
                attribute = file.canRead() ? "R" : "";
                attribute += file.canWrite() ? "W" : "";
                attribute = file.isHidden() ? "H" : "";
            }
            System.out.printf("%s  %3s  %10s  %s  \n", dt.format(new Date(file.lastModified())), attribute, size, name);
        }
    }
}
