package java_basic_03_etc;

import java.util.Scanner;

class Jumin {
    String jumin;

//    static boolean checkNum(String jumin){
////        char[] cArr = jumin.toCharArray();
////        for(int i=0; i<6; i++){
////            if(cArr[i] < '0' || cArr[i] > '9'){
////                return false;
////            }
////        }
////        if(cArr[7] != '-') return false;
////
////        for(int i=8; i< cArr.length; i++){
////            if(cArr[i] < '0' || cArr[i] > '9'){
////                return false;
////            }
////        }
////        return true;
//        if(!jumin.matches("[0-9]{6}-[0-9]{7}")){
//            return false;
//        }
//         return true;
//    }

    static boolean checkLength(String jumin){

            return jumin.length() == 14 ? true : false;
    }
}
public class Ex_Jumin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String jumin = scan.nextLine();
        System.out.println("주민번호 14자리: " + Jumin.checkLength(jumin));
    }
}

