package java_basic_03_etc;

public class Ex08_String_Method {
    public static void main(String[] args) {
        //모든 함수 암기는 불가능..
        String str = "hello";
        String concatstr = str.concat(" world");
        System.out.println(concatstr);

        boolean containsstr = str.contains("ello");
        System.out.println(containsstr);

        //암기할만한것들
        //length(), indexOf(), substring(), replace(), split() ...

        String str7 = "홍     길     동";
        //replace 사용

        //퀴즈
        String jumin = "123456-1234567";
        //주민번호의 합
        char[] cArr = jumin.replace("-","").toCharArray();
        int sum = 0;
        for(char c : cArr){
            int num = Integer.parseInt(String.valueOf(c));
            sum += num;
        }
        System.out.println(sum);
    }
}
