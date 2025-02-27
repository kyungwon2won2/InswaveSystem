package java_basic_04_oop2;

interface ToDo{
    void eat();
    void sleep();
}

class Car1{
    private String carNumber;
    private String model;
    private Engine engine;
    private Radio radio;

    Car1(){
        this.engine = new Engine();
        this.radio = new Radio();
    }

    public void move(){

    }
}

class Engine{

}

class Radio{

}

class Person implements ToDo{
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    public void drive(Car1 car1){

    }
}

class Student extends Person{
    private Long studentId;
    private String major;
    private Subject[] subjectList;

    public Student(String name, int age, String address, Long studentId, String major) {
        super(name, age, address);
        this.studentId = studentId;
        this.major = major;
        this.subjectList = new Subject[10];
    }

    public void study(){

    }

    public void addSubject(Subject subject){

    }
}

class Subject{
    private Long subjectId;
    private String subjectName;
    private Student[] studentList;

    public Subject(Long subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.studentList = new Student[10];
    }

    public void add(Student student){

    }
}
public class ClassDiagram {
    public static void main(String[] args) {

    }
}
