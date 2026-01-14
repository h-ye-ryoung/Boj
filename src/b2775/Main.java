package b2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // k층 n호 배열
        int[][] array = new int[15][15];

        // 0층 초기화
        for (int i = 1; i < 15; i++) {
            array[0][i] = i;
        }

        for (int i = 1; i < 15; i++) { //i층 (1층~14층)
            for (int j = 1; j < 15; j++) { //j호 (1호~14호)
                array[i][j] = array[i][j-1] + array[i-1][j]; //i층 j호 = i층 j-1호 + i-1층 j호 (같은층 직전호 사람수 + 아래층 같은호 사람수)
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(array[k][n]);
        }
    }
}
