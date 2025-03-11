package java_basic_03_etc;

import java.util.ArrayList;
import java.util.List;

public class Ex16_Debug {
    public static void main(String[] args) {
        System.out.println("디버깅 시작!");

        List<Integer> numbers = generateNumbers(10); // 숫자 리스트 생성
        int sum = calculateSum(numbers); // 합계 계산

        System.out.println("총 합계: " + sum);
        System.out.println("디버깅 종료!");
    }

    // 1부터 N까지 숫자를 리스트에 추가하는 메서드
    public static List<Integer> generateNumbers(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    // 리스트에 있는 숫자들의 합을 구하는 메서드
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
