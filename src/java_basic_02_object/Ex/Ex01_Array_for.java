package java_basic_02_object.Ex;

public class Ex01_Array_for {
    public static void main(String[] args) {
        /*
        for문 : 향상된 for문, 개선된 for문
        JAVA : for(type변수명 : 배열 or Collection) {}
        javascript : for(let 변수명 in 배열 or Collection) {} .... of
         */

        //개선된 for문
        int[] arr = {5, 6, 7, 8};
        for(int value : arr){
            System.out.println(value);
        }

        String[] strarr = {"A", "B", "C", "D", "FFFF"};
        for(String value : strarr){
            System.out.println(value);
        }

    }
}
