package java_basic_03_etc.kr.or.utils;

import java.io.IOException;

/*
-throws-
설계도
설계자 입장에서 고민 : 설계도를 사용하는 개발자가 어떤 상화에 반드시 예외처리 했으면...(강제)

내 설계도를 사용하는 사람에게 강제로 예외처리하도록 **예외객체 던지기
 */
public class ExClass {
    public ExClass(String path) throws IOException, NullPointerException{ //경로 입력을 원함.
        System.out.println("path : " + path);
    }
}
