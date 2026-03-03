package b1676;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 팩토리얼을 끝까지 할수는 X
        // 마지막에 딸린 0들의 N 개수 = 10으로 N번 나누어 떨어진다

        // 곱셈이니까! 곱할때마다 10으로 나누어 떨어지는지 확인해보고,
        // 나누어 떨어지면 count 1 추가 & 10으로 나누기

        long num = 1;
        long count = 0;
        for (int i = 1; i <= N; i++) {
            num *= i;
            while (num % 10 == 0) {
                count++;
                num /= 10;
            }
            // 그리고 어차피 곱해서 0으로 끝나는지 아닌지는 끝자리만 관련 있으니까
            // 주기적으로 계속 10000 이상의 자리를 날려버리면?? (100은 틀렸음)
            num %= 10000;
        }

        System.out.println(count);
    }
}
