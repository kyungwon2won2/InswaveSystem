package java_basic_04_oop.kr.or.sosa;

//DTO, VO, DOMAIN 클래스 - 데이터를 담을 수 있는 클래스
public class Emp {
    private int empno;
    private String ename;

    public Emp(){

    }

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

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

    //toString()은 Object의 함수를 재정의한 것
    /*
    [질문]
    전제조건 : toString()을 재정의 하지않았음.
    Emp emp = new Emp();

    1.System.out.println(emp) -> 주소값 출력
    2.System.out.println(emp.toString()) -> 주소값 출력
    ---이때 개발자가 상속관계에 toString()을 재정의 할 수 있다. -> 멤머필드의 데이터 확인 및 출력용도

     */
    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                '}';
    }
}
