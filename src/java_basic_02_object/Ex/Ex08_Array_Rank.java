package java_basic_02_object.Ex;

public class Ex08_Array_Rank {
    public static void main(String[] args) {
        /*
        다차원 배열 (2차원)
        [행] [열]
        시간표, 좌표값, 영화관 좌석, 오목, 엑셀
         */
        int[][] score = new int[3][2]; //3행2열

        int[][] score2 = new int[][] {{11,12},{13,14},{15,16}};
        //개선된 for문
        for (int[] ints : score2) { // -> 그림을 기억하자.
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
