package java_basic_object.Ex;

import java_basic_object.kr.or.sosa.dto.Cinema;

public class Ex_Cinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        int choice = cinema.showMenu();
        cinema.Menu(choice);
    }
}
