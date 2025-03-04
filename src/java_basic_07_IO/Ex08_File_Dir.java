package java_basic_07_IO;

import java.io.File;

public class Ex08_File_Dir {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if(args.length != 1){
            System.out.println("사용법 : java 파일명 [디렉토리명]");
            System.exit(0); //프로세스 강제종료
        }
        File f = new File(args[0]); //new File("C:\\Temp")
        if(f.exists() || f.isDirectory()){
            //입력한 파일 또는 폴더가 존재하지 않으면...
            System.out.println("유효하지 않은 경로입니다.");
            System.exit(0);
        }
        //강제 종료 프로세스를 지나서.... 실제 존재하는 경로
        //POINT
        File[] files = f.listFiles(); //Temp 안에 있는 하나 하나 자원을 File 객체에 담아서...
        //[1.txt][2.txt][new.txt]....[곰폴더][기러기폴더] >> 배열 타입 File
        for(int i=0; i<files.length; i++){
            System.out.println(files[i].getName()); // 폴더명 or 파일명 구분 안됨
            String name = files[i].getName();
            System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
        }
    }
}
