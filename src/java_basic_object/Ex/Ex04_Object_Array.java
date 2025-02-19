package java_basic_object.Ex;

class Person{
    String name;
    int age;
    //만약 사람을 만들때 이름과 니이의 초기값을 강제하고 싶다면 -> 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void print(){
        System.out.println(this.name + " " + this.age);
    }
}

public class Ex04_Object_Array {
    public static void main(String[] args) {
        Person person = new Person("홍길동", 100);
        //사람 3명 만든다 -> 같은 타입의 변수가 나열됨 -> 배열사용
        Person[] people = new Person[3]; //heap 메모리에 3개의 방이 연속된 배열만 생성 -> 빈 방
        //방 채우기
        people[2] = new Person("홍길동", 100);
        System.out.println(people[2].name + ", " + people[2].age);
    }
}
