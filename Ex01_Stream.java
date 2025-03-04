package java_basic_07_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
/*
I/O (input/output)

입력과 출력
입력장치:키보드 , 마우스
출력장치:모니터

Stream :시냇가 , 흐르다 , 흐름 (통로, 중간매개체)
(빨대) 작업.... 입력, 출력,

처리하는 데이터 종류 : 이미지 , 파일 , 문자 (stream 을 달리한다)

-----------------------------------------------------
JAVA API >> Stream  작업에 필요한 class 가지고 있어요
I/O 기본 단위는 Byte (기본)

추상 클래스
InputStream , OutPutStream (추상함수 ... 재정의)

당신이 Byte 데이터 작업
입력시(read) : InputStream 상속 구현하는 클래스를 사용 (제공해 줄게)
출력시(write): OutPutStream 상속 구현하는 클래스를 사용 (제공해 줄게)

그 대상이
1. Memory : ByteArrayInputStream (배열을 read) > 사실 메모리에 write ,read > Array , Collection
2. File   : FileInputStream (******)


1. Memory : ByteArrayOutputStream(배열에 write) > 사실 메모리에 write ,read > Array , Collection
2. File   : FileOutputStream (*******)

목적 : student.txt >> 성적 write >> 기록된 성적을 > 성적 read > 파일 기반의 데이터 처리
*/
public class Ex01_Stream {
    public static void main(String[] args) {

        //byte(-128 ~ 127) 정수값을 저장
        //단독으로 사용될 일이 없어요 >> 단체 >> 배열
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null; //outSrc 현재 메모리를 가지고 있지 않아요

        //빨대 준비 > 대상 >  memory > read , write
        ByteArrayInputStream input = null;   //빨대 (통로) 입력(read)
        ByteArrayOutputStream output = null; //빨대 (통로) 출력(write)

        input = new ByteArrayInputStream(inSrc); //input(read) >> inSrc
        output = new ByteArrayOutputStream(); // write 가지고 있어요

        System.out.println("outSrc before : " + Arrays.toString(outSrc));

        //공식같은 로직(암기)
        int data=0;
		/*
		while(input.read() != -1) {
			System.out.println(input.read());
			//내부적으로 next()
		}
		*/

        while ((data = input.read()) != -1) {
            //System.out.println(data);
            output.write(data); // 통로(출력) 안에 데이터를 담고 있을 수 있어요
        }

        //byte[] outSrc = null;  //생성된 배열의 주소값
        outSrc = output.toByteArray(); //자신이 머금고 있던 데이터를 배열로 만들어서 그 주소를 리턴

        System.out.println("outSrc after : " + Arrays.toString(outSrc));
    }

}
