package b11050;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // n-1Ck + n-1Ck-1 = nCk
        // nC0 = 1 / nCn = 1

        // 점화식을 채우는 재귀함수
        int result = recur(N, K);
        System.out.println(result);
    }

    public static int recur(int N, int K) {
        if (K==0) { //초기값
            return 1;
        }
        if (N==K) { //초기값
            return 1;
        }
        return recur(N-1, K) + recur(N-1, K-1);
    }
}
