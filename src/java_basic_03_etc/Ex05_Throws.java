package java_basic_03_etc;

import java_basic_03_etc.kr.or.utils.ExClass;

import java.io.IOException;

public class Ex05_Throws {
    public static void main(String[] args) {
        try {
            ExClass ex = new ExClass("C:\\Temp");
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }
}
