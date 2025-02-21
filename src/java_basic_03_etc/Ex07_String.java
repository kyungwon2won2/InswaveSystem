package java_basic_03_etc;
/*
String 은 사실은 클래스이다. (문자를 여러개 담을 수 있는 클래스)
그래서 String str = new Sting("홍길동"); 으로 썼어야했다.
하지만 String str = "홍길동" 으로 써도 문제가 없고, 지금까지 이렇게 써왔다.

String이 가지고 있는 함수 (다루는 대부분의 데이터 문자열 : 문자를 자르고, 합치고, 나누고 조합)
String > 일반함수 + static 함수
 */

public class Ex07_String {
    public static void main(String[] args) {
        String ste1 = ""; //초기화
        String str2 = null; // 초기화

        String[] strarr = {"abc", "abcd", "abcde"};
        for(String s : strarr){
            System.out.println(s);
        }

        //**String 사용 방법 : 8가지 기본 타입과 같은 방법으로 사용하면 된다.
        String str3 = "홍길동"; //내부적으로 char[]으로 문자열을 관리함.
        System.out.println(str3.length()); //그래서 길이를 찍어볼 수 있음.

        System.out.println(str3);
        System.out.println(str3.toString()); //Object의 toString()은 주소값이 나온다...String class가 재정의

        //정식 표기
        String sdata = new String("김유신");
        System.out.println(sdata);

        String s1 = "AAA";
        String s2 = "AAA";

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1 == s2); // -> tru
        //== : 값을 비교
        //**메모리에 같은 문자열이 있으면 문자열을 재사용

        //문자열의 비교는 == 하지 마라! -> s1.equals(s2) 사용해라. : 주소값을 찾아가서 그 안의 값을 비교함.
        //이유
        String s3 = new String("BBB");
        String s4 = new String("BBB");
        System.out.println(s3 == s4); //false
        System.out.println(s3.equals(s4)); //true

        String s = "A";
        s += "B";
        s += "C";
        System.out.println(s);
        s = "A";
        System.out.println(s);
        //초급자 입장 : String 변수로 값을 누적하지마라. -> StringBuilder, StringBuffer 사용하자.
    }
}
