package java_basic_oop.src;

/*
사원은 사번을 가지고있다. 숫자
사원은 이름을 가지고있다. 문자열
사원은 급여정보을 가지고있다. 숫자
사원은 직종을 가지고있다. 문자열

4개의 정보는 캡슐화
모든 read write 할 수 있게

사원의 모든 정보를 출력하는 기능

가장 빠른방법으로
 */
public class Emp {
    private int empNum;
    private String name;
    private int salary;
    private String jobCategory;

    public int getEmpNum() {
        return empNum;
    }

//    public void setEmpNum(int empNum) {
//        this.empNum = empNum;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getSalary() {
        return salary;
    }

//    public void setSalary(int salary) {
//        this.salary = salary;
//    }

    public String getJobCategory() {
        return jobCategory;
    }

//    public void setJobCategory(String jobCategory) {
//        this.jobCategory = jobCategory;
//    }

    //함수로 값을 할당하게 함수를 만드세요
    public void setEverything(int empNum, String name, int salary, String jobCategory){
        this.empNum = empNum;
        this.name = name;
        this.salary = salary;
        this.jobCategory = jobCategory;
    }

    public void printEmpInfo(){
        System.out.printf("사번 : %d, 이름 : %s, 급여 : %d, 직종 : %s", empNum,name,salary,jobCategory);
    }
}
