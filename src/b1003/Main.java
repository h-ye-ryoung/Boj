package b1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // N일 때, 0 또는 1이 몇번 쓰였는지 저장하는 배열 (N 범위: 0~40)
        int[] array0 = new int[41];
        int[] array1 = new int[41];

        // 초기화
        array0[0] = 1;
        array0[1] = 0;
        array1[0] = 0;
        array1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            array0[i] = array0[i-1] + array0[i-2]; //N에서 0이 쓰인 횟수 = N-1에서 0이 쓰인 횟수 + N-2에서 0이 쓰인 횟수
            array1[i] = array1[i-1] + array1[i-2]; //1이 쓰인 횟수도 위와 같음
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(array0[N]).append(" ").append(array1[N]).append("\n");
        }

        System.out.println(sb);
    }
}
