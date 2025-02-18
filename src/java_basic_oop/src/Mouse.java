package java_basic_oop.src;

/*
마우스는 한 점을 가지고있다. (좌표 : x,y)
 */
public class Mouse {
    //상태정보
    private int x;
    private int y;

    //캡슐화 - 직접적인 접근을 허용하지 않고 간접적으로 접근 허용
    //간접할당
    //통해서 (함수) : read, write - 함수는 하나의 기능만을 구현한다.

    //함수 : 접근자 + return type(void) + 이름 (parameter) { ... }

    //관용적 (read --> get)
    //x를 read 하는 함수
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //특수한 목적 : 캡슐화된 member field read 할 수 있는 함수 : getter 함수
    //특수한 목적 : 캡슐화된 member field write 할 수 있는 함수 : setter 함수

    public void setX(int x){
        this.x = x; //할당
    }

    public void setY(int y){
        this.y = y;
    }

    public String getReadMouseData(){
        return "x:" + x + " " + "y:" + y;
    }
}
