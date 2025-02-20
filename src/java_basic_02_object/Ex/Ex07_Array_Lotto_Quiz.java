package java_basic_02_object.Ex;
/*
1. 1~45 난수를 발생시켜서 6개의 정수값을 배열에 담으세요. -> 중복값 발생
2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안된다. -> 검증
3. 배열에 있는 6개의 값은 낮은 순으로 정렬.
4. 위 결과를 출력하라.
 */

public class Ex07_Array_Lotto_Quiz {
    public static void main(String[] args) {
        /*
        1. 방 6개 생성
        2. 방에 값넣기, 검증하기
        3. 방에 있는 값 정렬
        4. 방에 값 출력
         */
        int[] output = new int[6];
        int[] num = new int[46];
        for(int i=0; i< output.length; i++){
            output[i] = (int) (Math.random() * 45 + 1);
            if(num[output[i]] == 0){
                num[output[i]] = 1;
            }else{
                i--;
            }

        }

        for(int i=0; i< output.length; i++){
            for(int j=i+1; j< output.length; j++){
                if(output[i] > output[j]){
                    int temp = output[i];
                    output[i] = output[j];
                    output[j] = temp;
                }
            }
        }

        for (int j : output) {
            System.out.println(j);
        }
    }
}
