package b11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        // 인출 시간이 최소가 되게 정렬1
        Arrays.sort(time);

        // 구간합으로 각 사람이 걸리는 시간 구하기
        int[] S = new int[N];
        S[0] = time[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + time[i];
        }

        // 모두 더해서 모든 사람의 시간의 합 구하기
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += S[i];
        }

        System.out.print(result);
    }
}
