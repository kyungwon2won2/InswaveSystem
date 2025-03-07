package java_basic_08_Stream_Ramda;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
Java 는 객체지향 언어이기 때문에 기본적으로 함수형 프로그래밍이 불가능하다

JDK8 Stream API 제공 ... 람다식을 사용

함수형 인터페이스 등을 지원 ... java 이용해서 javascript 에서 사용했던 함수형을 API를 통해서 제공
그 대표 Stream API  는 데이터를 추상화하고 처리하는데 자주 사용하는 함수를 정의해 두었다
ex) select * from emp where sal > 2000 and ename ='길동' and ...
위에서 쓰는 방식을  자바에서도 추상화된 함수를 구현할 수 있다  >> Stream API 구현 람다식 ....
표준화 , 재사용성  높일 수 있다
*/

/*
enum Gender{
    Male, FeMale
}

enum SearchOption{
    Location , Gender
}


// DTO(VO) 객체
@Setter
@Getter
class Customer{
    private String id;
    private String location;
    private Gender gender;  //enum 열거 타입
    private int age;


    public Customer(String id, String location, Gender gender, int age) {
        super();
        this.id = id;
        this.location = location;
        this.gender = gender;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Customer [id=" + id + ", location=" + location + ", gender=" + gender + ", age=" + age + "]";
    }

}




class CustomerService{
    private List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer newCustomer) {
        this.customers.add(newCustomer);
    }

    //요구사항
    //location 지역으로 검색된 고객목록 추출
    //parameter  location
    //명령형 (imperative)
    public List<Customer> searchCustomerByLoation(String location){

        List<Customer> findCustomers = new ArrayList<>();
        for(Customer customer : customers) {
            if(customer.getLocation().equals(location)) {
                findCustomers.add(customer);
            }
        }
        return findCustomers;
    }

    //요구사항
    //성별로 검색하기
    public List<Customer> searchCustomerByGender(Gender gender){

        List<Customer> findCustomers = new ArrayList<>();
        for(Customer customer : customers) {
            if(customer.getGender().equals(gender)) {
                findCustomers.add(customer);
            }
        }
        return findCustomers;
    }

    //요구사항
    //지역 검색 하는 함수와 성별로 검색하는 함수를 통합
    public List<Customer> searchCustomerBy(SearchOption searchoption, String searchvalue){
        List<Customer> findCustomers = new ArrayList<>();
        for(Customer customer : customers) {
            if(searchoption.equals(searchoption.Location)) {
                //지역검색
                if(customer.getLocation().equals(searchvalue)) {
                    findCustomers.add(customer);
                }
            }else if(searchoption.equals(searchoption.Gender)) {
                //성별검색
                if(customer.getGender().name().equals(searchvalue)) {  //주의
                    findCustomers.add(customer);
                }
            }

        }
        return findCustomers;
    }
}

*/


public class F_Program2 {

    public static void main(String[] args) {
        /*
        CustomerService service = new CustomerService();
        initData(service);

        //지역검색
        List<Customer> result = service.searchCustomerByLoation("Seoul");
        for(Customer customer : result) {
            System.out.println(customer);
        }
        System.out.println("-------------------------------------------");

        //성별로 검색
        List<Customer> result2 = service.searchCustomerByGender(Gender.FeMale);
        for(Customer customer : result2) {
            System.out.println(customer);
        }


        System.out.println("******************************************");

        List<Customer> results = null;
        //results = service.searchCustomerBy(SearchOption.Location, "Gwangju");
        //for(Customer customer : results) {
        //	System.out.println(customer);
        //}

        results = service.searchCustomerBy(SearchOption.Gender, "Male");
        for(Customer customer : results) {
            System.out.println(customer);
        }
    }
    public static void initData(CustomerService service) {
        service.addCustomer(new Customer("customer01", "Seoul",   Gender.Male, 30));
        service.addCustomer(new Customer("customer02", "Busan",   Gender.FeMale, 55));
        service.addCustomer(new Customer("customer03", "Seoul",   Gender.FeMale, 13));
        service.addCustomer(new Customer("customer04", "Gwangju", Gender.Male, 27));
        service.addCustomer(new Customer("customer05", "Gwangju", Gender.FeMale, 60));
        service.addCustomer(new Customer("customer06", "Incheon", Gender.Male, 29));
        service.addCustomer(new Customer("customer07", "Seoul",   Gender.Male, 42));
        service.addCustomer(new Customer("customer08", "Seoul",   Gender.FeMale, 45));
        service.addCustomer(new Customer("customer09", "Seoul",   Gender.FeMale, 33));
        service.addCustomer(new Customer("customer10", "Seoul",   Gender.Male, 20));
    }
    */
    }

}


/*
함수형 프로그래밍은 선언형 프로그래밍을 따르는 대표적인 패러다임이다


함수형 프로그래밍은 함수들의 집합으로 프로그램을 구성하는 것을 의미합니다
자바에 함수형 프로그래밍 도입은 프로그램 구현 방식에  큰 변화를 가져 왔습니다
함수형 프로그래밍의 함수는
1. 순수함수(Pure function)  : 함수의 수행 결과(output) 입력(input) 따라 결정
                          : 함수의 실행에 따른 부수효과(side-effect)가 발생하지 않음
2. 일급객체(First-class)    : 함수를 변수 혹은 특정 데이터 구조에 담을 수 있음
                          : 함수를 파라미터를 통해 전달할 수 있고 결과를 변환 할 수 있음

3. 불변의 자료구조 또는 영속 자료구조등 과 같은 특성을 갖습니다
   : 특정 변수/객체의 자료를 직접 변경하지 않고 새로운 인스턴스를 통해 의도하지 않은 변경을 방지


일급객체(First-class Object)란 다른 객체들에 일반적으로 적용 가능한 연산을
모두 지원하는 객체를 가리킨다. [위키백과]
일급객체의 조건에 대해서 정의를 내려보겠다.

변수에 할당(assignment)할 수 있다.
다른 함수를 인자(argument)로 전달 받는다.
다른 함수의 결과로서 리턴될 수 있다.
위에 대한 조건으로 인해 알 수 있는 것은 함수를 데이터(string, number, boolean, array, object) 다루 듯이
다룰 수 있다는 점이다.

여기서 데이터를 다룬다는 의미는 변수에 할당이 가능하다는 것으로, 함수 역시 할당이 가능하다는 의미이다.



*/