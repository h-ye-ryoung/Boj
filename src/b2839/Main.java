package b2839;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 5로 나눴을때 나머지가 0이 아니면 3으로 한번만 나눠봐 -> 반복
        int count = 0;
        while (N >= 3) {
            if (N % 5 != 0) {
                N -= 3;
                count++;
            } else {
                N -= 5;
                count++;
            }
        }

        if (N == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
