package java_basic_04_oop2;

interface ToDo{
    void eat();
    void sleep();
}

class Car1{
    private String carNumber;
    private String model;

    Car1(){
        Engine engine = new Engine();
        Radio radio = new Radio();
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

    public void study(){

    }

    public void addSubject(Subject subject){

    }
}

class Subject{
    private Long subjectId;
    private String subjectName;
    private Student[] studentList;

    public void add(Student student){

    }
}
public class ClassDiagram {
}
