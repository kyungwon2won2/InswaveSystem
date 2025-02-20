package java_basic_03_etc;
/*
오류
1.에러(error) : 네트워크 장애, 메모리 누수, 하드웨어 >> 개발자가 코드적으로 해결 불가
2.예외(exception) : 개발자가 코드 실수로 발생할 수 있는 문제 > 문제 인지 > 문제 코드 찾아서 수정 > 배포
    -컴파일시 실행안됨
    -런타임시 문제 발생 > 프로그램 강제 종료 > 문제 발생 부분 > 방어막(예외처리) > 일단 진행되도록..

예외처리 : 프로그램을 안정적으로 처리 > 원인 분석 > 코드 수정 > 다시 배포

try{
    >>런타임시 문제가 생길 수 있는 코드
    >>문제발생 > 예외 관련된 객체 자동 생성 > catch에 전달
}catch(Exception e){
    >>발생된 예외정보를 담고 있는 객체의 주소를 받음. 예시) 문제가 발생하면 자동으로 new ArrayIndexOutOfBoundsException() 객체 생성
    >>예외 객체를 통해서 문제 파악
    >>처리 - 코드수정x -> 1.관리자에게 요청  2.로그기록(파일)  **3.강제종료 되는것을 막음
}finally{
    >>문제가 발생/발생되지 않아도 강제적으로 실행되는 코드
    >>함수 return - 원래는 함수 종료  -> finally를 만나면 무조건 finally 안의 코드는 강제실행
    >>네트워크(I/O) , DB 작업 (close())
}
 */

public class Ex01_Exception {
    public static void main(String[] args) {
        /*
        -예외처리x-

        System.out.println("main start");
        System.out.println(0/0);
        System.out.println("main end");
         */
        System.out.println("main start");
        try{
            System.out.println(0/0);
        }catch (Exception e){
            //문제 파악 전달
            System.out.println("문제 발생 : " + e.getMessage());
            //문제 상황을 개발자에게 전달 -> try 코드 수정하도록 요청.
        }
        System.out.println("main end");



    }
}
