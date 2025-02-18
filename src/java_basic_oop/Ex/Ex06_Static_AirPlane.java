package java_basic_oop.Ex;

import java_basic_oop.src.AirPlane;

public class Ex06_Static_AirPlane {
    public static void main(String[] args){
        AirPlane air101 = new AirPlane("대한항공", 101);

        AirPlane air202 = new AirPlane("아시아나", 202);

        air202.printCnt();

    }
}
