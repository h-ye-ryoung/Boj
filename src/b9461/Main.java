package b9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 파도반 수열 저장 배열 -> P(1)부터 P(100)까지 저장
        long[] array = new long[101];

        // 초기화
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        array[4] = 2;
        array[5] = 2;

        for (int i = 6; i <= 100; i++) {
            array[i] = array[i-5] + array[i-1];
        }

        // 수열 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(array[N]).append("\n");
        }

        System.out.println(sb);
    }
}
