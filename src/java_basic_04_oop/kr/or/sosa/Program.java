package java_basic_04_oop.kr.or.sosa;

import lombok.Builder;

public class Program {
    public static void main(String[] args) {
        Person p = Person.builder()
                .name("빌더이름")
                .age(1515)
                .build();
        Person person = new Person();
        person.setName("홍길동");
        person.setAge(100);

        System.out.println(p.getName());

        System.out.println(person.toString());
    }
}
