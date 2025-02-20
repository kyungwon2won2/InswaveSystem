package java_basic_03_etc;
/*
try{

}catch(Exception e){

}finally{
    강제로 실행되는 블럭
}

finally 블록을 구현했다면 ... 예외가 발생하던 안하던 강제적으로 실행되는 블럭 (코드 처리)
ex) I/O, 네트워크 자원, DB 자원 -> 자원.close()
 */

import java.io.IOException;

public class Ex04_finally {

    static void copyFiles(){
        System.out.println("copy files");
    }
    static void startInstall(){
        System.out.println("Install...");
    }
    static void fileDelete(){
        System.out.println("file delete");
    }
    public static void main(String[] args) {
        /*
        실제로는 예외가 아니지만 내가 어떤 상황을 얘외하고 예외객체를 생성 던질 수 있다.
        throw 내가 예외를 생성해서 (메시지 정의 기능)
         */
        try{
            copyFiles();
            startInstall();
            throw new IOException("install 도중 문제 발생!!!"); //을 이용해서 사용자 정의 예외처리 가능(시뮬레이션을 위해서)
        }catch (Exception e){
            System.out.println("예외발생 : " + e.getMessage());
        }finally {
            //예외가 발생하던 안하던 delete는 강제로 실행
            //return을 만나도 finally는 강제 실행
            fileDelete();
        }
    }
}
