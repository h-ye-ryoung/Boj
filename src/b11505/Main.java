package b11505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;
    static int k2; //2의 k제곱
    static StringBuilder sb = new StringBuilder();
    static final long num = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 트리 초기화
        k2 = 1;
        while(k2 < N) {
            k2 <<= 1;
        }
        int size = k2 << 1;
        tree = new long[size];

        Arrays.fill(tree, 1); //자식의 값을 부모에 곱해 넣을 거니까 트리를 전부 1로 채우기

        // 리프 노드 채우기
        for (int i = k2; i < k2+N; i++) {
            tree[i] = Long.parseLong(br.readLine()) % num;
        }

        // 맨 뒤부터 순회하며 나머지 노드 채우기
        for (int i = size-1; i >= 2; i--) {
            tree[i/2] = tree[i/2] * tree[i] % num;
        }

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) change(b,c);
            else print(b,c);
        }

        System.out.println(sb);
    }

    public static void change(int b, int c) {
        int bIdx = b + k2 - 1;
        tree[bIdx] = c % num; //리프 값 바꿔주기

        for (int i = bIdx; i >= 2; i = i / 2) { //i노드 -> 위로 올라감 (루트 직전까지)
            //기존 대상이 0일 경우도 고려해야 함: 값 바꾸고 무조건 옆 노드와 함께 구간곱 계산..
            //0으로 나누지 못하니까 기존 값으로 나누고 새로운 값으로 곱할 수 없음!
            if (i % 2 == 0) { //노드 위치에 따라 부모 값 바꿔주기
                tree[i/2] = tree[i] * tree[i+1] % num;
            } else {
                tree[i/2] = tree[i] * tree[i-1] % num;
            }
        }
    }

    public static void print(int b, int c) {
        long result = 1;
        int bIdx = b + k2 - 1;
        int cIdx = c + k2 - 1;

        while (bIdx <= cIdx) {
            if (bIdx == cIdx) {
                result = result * tree[bIdx] % num;
                break;
            }
            if (bIdx % 2 == 1) {
                result = result * tree[bIdx] % num;
            }
            bIdx = (bIdx + 1)/2;
            if ((cIdx % 2) == 0) {
                result = result * tree[cIdx] % num;
            }
            cIdx = (cIdx - 1)/2;
        }

        sb.append(result).append("\n");
    }
}
