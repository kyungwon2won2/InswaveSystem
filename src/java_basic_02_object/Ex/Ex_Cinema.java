package java_basic_02_object.Ex;

import java_basic_02_object.kr.or.sosa.dto.Cinema;

public class Ex_Cinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        int choice = cinema.showMenu();
        cinema.Menu(choice);
    }
}

///예매하기 할때 1-1을 입력하는것이 아니라 1을 넣으면 ArrayIndexOutOfBoundsException 예외발생. -> 수정해야함.
