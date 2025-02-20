package java_basic_02_object.kr.or.sosa.dto;
/*
Web > MVC 패턴
Model > dto(vo, domain, 데이터를 담을 수 있는 클래스), dao, service
데이터 : 사원 1명(select empno, ename from emp where empno==7788)
 */
public class Emp {
    private int empno;
    private String ename;

    //생성자 - 강제성을 부여할것인가?!
    //요구사항을 기반으로 해서 코드화
    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    //시번과 이름 정보를 각각 read, write 할 수 있다. - getter, setter
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String empInfoData() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                '}';
    }
}
