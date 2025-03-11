package java_basic_08_Stream_Ramda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Java 는 객체지향 언어이기 때문에 기본적으로 함수형 프로그래밍이 불가능하다

JDK8 Stream API 제공 ... 람다식을 사용

함수형 인터페이스 등을 지원 ... java 이용해서 javascript 에서 사용했던 함수형을 API를 통해서 제공
그 대표 Stream API  는 데이터를 추상화하고 처리하는데 자주 사용하는 함수를 정의해 두었다
ex) select * from emp where sal > 2000 and ename ='길동' and ...
위에서 쓰는 방식을  자바에서도 추상화된 함수를 구현할 수 있다  >> Stream API 구현 람다식 ....
표준화 , 재사용성  높일 수 있다
*/
public class F_Program4 {

    public static void main(String[] args) {
        String[] namearr = {"Hulk","Captain","IronMan"};
        List<String> namelist = Arrays.asList(namearr);

		/*
		아래 코드는 좋은 코드 입니다
		만약엔 더 간결하게 가독성 높게 ... 원본데이터 변형을 가하지 않고 ...
		할 수 있는 방법이 있다면 더 좋은 코드 .....

		JAVA Stream API 원본의 데이터 변경 없이 간결한 형태의 코드 작성 방법을 가지고 있다

		*/
		/*
		Arrays.sort(namearr);
		Collections.sort(namelist);

		for(String str : namearr) {
			System.out.println(str);
		}

		for(String str : namelist) {
			System.out.println(str);
		}
		*/
		/*
		  JAVA Stream API 사용해서 리팩토링을 해보자

		 */

        //1. 원본 데이터가 아닌 별도의 데이터 집합을 생성
        // Stream 은 Collection 보조하는 녀석 ....

        Stream<String> arraystream = Arrays.stream(namearr);
        Stream<String> namestream = namelist.stream();

        //복사된 데이터를 정렬해서 출력
        arraystream.sorted().forEach(System.out :: println);
        namestream.sorted().forEach(System.out :: println);

        //Stream API 사용하면 코드의 라인수도 줄이고 ,,, 가독성도 높이고 .... 그런데
        //쓰는 것은 개발자 마음.....
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
포스팅
https://velog.io/@reveloper-1311/%EC%9D%BC%EA%B8%89-%EA%B0%9D%EC%B2%B4First-Class-Object%EB%9E%80


*/