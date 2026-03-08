package b18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array); //의견 정렬

        // N의 0.15 값 -> 반올림..이 기억 안나
        int bottom15 = Math.round(N * 0.15F);

        // 아래 15%명과 위 15%명 빼고 평균 구하기
        float sum = 0;
        for (int i = bottom15; i < N-bottom15; i++) {
            sum += array[i];
        }
        int avg = Math.round(sum / (N-(bottom15*2)));

        System.out.println(avg);
    }
}
