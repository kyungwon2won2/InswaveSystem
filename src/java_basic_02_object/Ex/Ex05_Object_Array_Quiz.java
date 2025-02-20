package java_basic_02_object.Ex;

import java_basic_02_object.kr.or.sosa.dto.Emp;

public class Ex05_Object_Array_Quiz {
    public static void main(String[] args) {
        /*
        Emp 사원 클래스
        1.사원 3명을 만들어라.
        사원의 정보 - 1000,홍길동    2000,김유신    3000,유관순
        2.개선된 for문으로 3명의 사번, 이름 모두 출력
         */
        Emp[] emparr = {new Emp(1000, "홍길동"), new Emp(2000, "김유신"), new Emp(3000, "유관순")};

        for (Emp emp : emparr) {
            System.out.println(emp.empInfoData());
        }
    }
}
