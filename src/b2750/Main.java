package b2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) { //모든 수에 대해서 정렬 수행
            for (int j = 1; j < N-i; j++) { //큰 수가 제일 뒤로 밀려나게 하고, 그 이전까지만 반복
                if (array[j-1] > array[j]) { //array[0]과 array[1]부터 비교 시작
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp; //swap 직접 구현 ㅋㅋ...
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(array[i]);
        }
    }
}
