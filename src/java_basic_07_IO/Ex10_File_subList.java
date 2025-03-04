package java_basic_07_IO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
C:\\Temp 특정 폴더를 제시하면 그 하위에 있는 폴더 목록과 그 폴더 안에 자원 목록을 다 보고싶다.

 */
public class Ex10_File_subList {

    static int totalFiles = 0; // 하위폴더까지 다 포함한 전체 파일 수
    static int totalDirs = 0; // 하위폴더까지 다 포함한 전체 폴더 수

    static void printFileList(File file){
        System.out.println("Full Path: " + file.getAbsolutePath());

        List<Integer> subdir = new ArrayList<>();
        File[] files = file.listFiles();
        for(int i=0; i<files.length; i++){
            String filename = files[i].getName(); // 폴더명일 수도 있고 파일명일 수도 있다. -> 확인절차 필요
            if(files[i].isDirectory()){
                filename = "[DIR]" + filename;
                //POINT
                subdir.add(i); //폴더인 경우에 배열의 index를 ArrayList 통해서 관리하겠다.
            } else {
                filename = filename + "/" + files[i].length() + "byte";
            }
        }
        //폴더의 전체 개수
        //파일의 전체 개수
        int dirnum = subdir.size(); //ArrayList size subdir.add(i); 현재 주어진 폴더의 하위 폴더 개수
        int filenum = files.length - dirnum; //현재 주어진 폴더안에 파일 개수

        //누적개수 (하위 폴더 자원)
        totalDirs += dirnum;
        totalFiles += filenum;

        System.out.println("[Current DirNum]: " + dirnum);
        System.out.println("[Current FileNum]: " + filenum);

        System.out.println("*****************************************");
        /*
        POINT
        하위 폴더에 다시 하위 폴더가 존재하는 상황
        [0] > a.txt
        [1] > aaa 폴더 > a-1 폴더, a-2 폴더
        [2] > bbb 폴더 > b-1 폴더, b.txt, b.jpg
        [3] > java.jpg
         */
        //subdir.size : 기본 폴더의 하위 폴더 개수
        for(int i=0; i<subdir.size(); i++){ //ArrayList 배열안에 [3][4][10][11]
                                            //index 값 ... 가르키는 것이 폴더(directory)
            int index = subdir.get(i);
            //함수 호출 - 재귀 : 계속 안쪽으로 들어간다...
            printFileList(files[index]);
        }
    }

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("사용법 : java [실행할 파일명] [경로명]");
            System.exit(0); //강제로 프로세스 종료
        }
        File f = new File(args[0]); //C:\\Temp   or    C:\\Windows
        if(!f.exists() || !f.isDirectory()){
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        /// //////////////////////////////////////////////////////////
        //정상적인 경로... 실제로 폴더가 존재
        printFileList(f); // f에 담겨진것 -> 파일의 정보

        System.out.println("누적 총 파일수: " + totalFiles);
        System.out.println("누적 총 폴더수: " + totalDirs);
    }
}
