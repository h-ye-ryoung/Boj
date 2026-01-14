package b11051;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] C = new int[N+1][N+1];
        
        // 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    C[i][j] = 1;
                } else if (j == 0) {
                    C[i][j] = 1;
                } else if (j == 1) {
                    C[i][j] = i;
                } else {
                    C[i][j] = C[i-1][j] % 10007 + C[i-1][j-1] % 10007;
                }
            }
        }

        System.out.println(C[N][K] % 10007);
    }
}