package java_basic_03_etc;

public class Ex15_Debug {

    public static void main(String[] args) {
        int total = sum(10, 20);
        System.out.println("Result: " + total);
    }

    public static int sum(int a, int b) {
        int result = a + b;
        return result;
    }
}