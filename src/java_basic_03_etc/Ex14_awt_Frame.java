package java_basic_03_etc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends Frame {
    public MyFrame(String title) {
        super(title);
    }
}

class BtnClickHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("나 클릭... ");
    }
}

public class Ex14_awt_Frame {
    public static void main(String[] args) {
        MyFrame my = new MyFrame("Login");
        my.setSize(400, 300);
        my.setVisible(true);
        my.setLayout(new FlowLayout());

        //이벤트 (사건 : 정의되어 있다. - 클릭, 더블클릭 ..) -> 행위 (창을 띄워서 hello world 출력...)
        Button btn = new Button("one button");
        Button btn2 = new Button("two button");
        Button btn3 = new Button("three button");
        
        //버튼 클릭이라는 사건에 -> 행위 부여
        BtnClickHandler handler = new BtnClickHandler();
        btn.addActionListener(handler);
        btn2.addActionListener(handler);

        //그런데 클릭 기능을 하나의 button 에서만 쓸거다...재사용 x ---> 버튼 하나마다 각각 만들어줘야함 -> 생산성 x
        //->익명클래스로 해결
        btn3.addActionListener(new ActionListener() { //익명 클래스 (일회성) 클래스 이름 없이
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("인터페이스 익명 객체 구현..");
            }
        });
        my.add(btn);
        my.add(btn2);
        my.add(btn3);
    }
}
