package b1929;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] array = new int[N+1];
        for (int i = 2; i <= N; i++) { //배열에 2~N 넣어주기
            array[i] = i;
        }

        for (int i = 2; i <=N; i++) { //2~N 순회하면서
            if (array[i] == 0) continue;  //만약 수가 0이면(지워졌으면) pass

            //아니면 i의 2배수부터 ~ N까지 i씩(배수로) 증가하면서 해당 인덱스인 배열을 0으로 만듦
            for (int j = i*2; j <= N; j += i) {
                array[j] = 0;
            }

            //그리고, 현재 i가 M보다 작지 않으면 출력해주기
            if (i >= M) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
