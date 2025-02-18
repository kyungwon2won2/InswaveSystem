package java_basic_oop.kosa.src;

/*
노트북은 생산년도를 가지고있다. (고유정보)
노트북은 색상을 가지고있다. (상태정보)
노트북 마우스를 가지고있다. (부품정보) - 설계도 1장 추가 - class Mouse {} - 데이터타입
 */
public class NoteBook {
    private int year;
    private String color;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<0){
            year = 0;
        }else {
            this.year = year;
        }
    }

    public String getColor() {
        return color + " 색상";
    }

    public void setColor(String color) {
        this.color = color;
    }

    //일반함수 (정보조회)
    public void printNoteBookInfo(){
        System.out.println("노트북 색상: %s , color " );

    }


//    private Mouse mouse = new Mouse();

    //NoteBook notebook = new NoteBook() - 마우스가 같이 생성된다.
    //연관(복합연관) - 라이프 사이클이 같다.

    //학교는 학생을 가지고있다. - 두개의 라이프사이클은 다르다.

    //노트북 [ 필요에 따라서 ] 마우스를 가질 수 있다.
    //가진다 - 생성된 마우스 객체의 주소값을 가질 수 있다.
    //함수 ... 마우스가 필요하면 마우스의 주소값을 받겠다.

    public void handleMouse(Mouse mouse){
        mouse.setX(100);
        mouse.setY(200);
        String position = mouse.getReadMouseData();
        System.out.println(position);
    }

    /*
    객체지향 언어 : 상속, 다형성, 캡슐화
    캡슐화 : 직접할당을 막고 간접할당을 통해서 자원을 보호
    방법1 : 변수 앞에 private - 클래스 내부는 문제 없지만, 객체 입장에서는 보이지 않음
    방법2 : setter, getter 함수 -> 자동화(Tool, 롬복)
     */
}
