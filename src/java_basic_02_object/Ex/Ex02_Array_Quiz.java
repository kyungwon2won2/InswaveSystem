package java_basic_02_object.Ex;

public class Ex02_Array_Quiz {
    public static void main(String[] args) {
        int[] score = new int[] {79,88,97,54,56,95};
        int max = score[0];
        int min = score[0];

        //제어문을 통해서 max에 시험점수 중에서 최대값을 담고, min에는 최소값을 담아라.
        //단, for문 하나만 사용.

        for(int i=0; i<score.length; i++){
            if(min>score[i]){
                min = score[i];
            }
            if(max<score[i]){
                max = score[i];
            }
        }
        System.out.println("max: " + max + " min: " + min);
    }
}
