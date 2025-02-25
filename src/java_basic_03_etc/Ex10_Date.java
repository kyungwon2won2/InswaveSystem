package java_basic_03_etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex10_Date {
    public static void main(String[] args) {
        Date now = new Date(); //default 만 사용하고 나머지 생성자는 사용하지 마세요.
        System.out.println(now); //표준시
        String strnow = now.toString(); //Object 에서 재정의했기 때문에 주소값이 아닌 날짜형식이 출력된다.
        System.out.println(strnow);

        //JAVA API format 형식에 맞게(숫자, 날짜, 문자열)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); //결과 -> 문자열
        String strnow2 = sdf.format(now); // -> 포멧에 맞게 가공된 문자열
        System.out.println(strnow2);

        String exDate1 = "2025/01/01"; //문자열인데 날짜로 변환 가능한 형식
        String exDate2 = "20250101"; //문자열

        boolean result = checkDate(exDate1);
        System.out.println("결과 : " + result);

        boolean result2 = checkDate(exDate2);
        System.out.println("결과 : " + result2);

        /////////////////////////////////////////////////////////////////////////////
        Calendar cal = Calendar.getInstance();  //날짜 설정 local에 따라서.. 태국이 날짜 설정이 달라서..
        //Point
        System.out.println(cal.getTime()); // Calender 에서 Date 형식의 날짜를 얻어낼 수 있다.

        int year = cal.get(Calendar.YEAR); //날짜에서 연도만 뽑아준다.
        System.out.println(year);

        int week = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);

        String strWeek = null;
        switch(week){
            case Calendar.MONDAY : strWeek = "월"; break;
            case Calendar.TUESDAY : strWeek = "화"; break;
            case Calendar.WEDNESDAY : strWeek = "수"; break;
            case Calendar.THURSDAY : strWeek = "목"; break;
            case Calendar.FRIDAY : strWeek = "금"; break;
            case Calendar.SATURDAY : strWeek = "토"; break;
            default : strWeek = "일";
        }
        System.out.println("week : " + strWeek);

        int amPm = cal.get(Calendar.AM_PM);
        System.out.println(amPm);
        String strampm = null;
        if(amPm == Calendar.AM){
            strampm = "오전";
        }else{
            strampm = "오후";
        }
        System.out.println(strampm);


        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);


        String date01 = "2025/01/05";
        String date02 = "2025/01/01";

        try {
            Date format1 = new SimpleDateFormat("yyyy/MM/dd").parse(date01);
            Date format2 = new SimpleDateFormat("yyyy/MM/dd").parse(date02);
            System.out.println(format1);
            System.out.println(format2);

            long diffSec = (format1.getTime() - format2.getTime()) / 1000; //두 날짜간의 초 차이
            long diffMin = (format1.getTime() - format2.getTime()) / 60000; //두 날짜간의 분 차이
            long diffHor = (format1.getTime() - format2.getTime()) / 3600000; //두 날짜간의 시 차이
            long diffDays = diffSec / (24*60*60);

            System.out.println("초 차이 : " + diffSec);
            System.out.println("분 차이 : " + diffMin);
            System.out.println("시 차이 : " + diffHor);
            System.out.println("일 차이 : " + diffDays);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean checkDate(String checkDate){
        try{
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy/MM/dd"); //검증할 날짜 포멧 설정
            dateFormatParser.setLenient(false); //false 설정하면 입력한 값이 잘못된 형식일 경우에 강제 예외터짐
            dateFormatParser.parse(checkDate); //대상값이 포멧에 적용되는지를 확인하는 것
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
