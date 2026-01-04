package b2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;
    static int startIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 트리 배열 만들기
        int k = (int)Math.ceil(Math.log(N)/Math.log(2));
        int size = (int)Math.pow(2, (k+1)); //트리 사이즈
        tree = new long[size];

        // 리프 노드 채우기
        startIdx = (int)Math.pow(2, k); //리프노드 시작 인덱스
        for (int i = startIdx; i < startIdx+N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // 나머지 노드 순서대로 채우기 (맨 끝 노드부터 순회)
        for (int i = size-1; i >= 2; i--) {
            tree[i/2] += tree[i]; // 부모 노드에 자신 더하기
        }

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int swit = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (swit==1) change(b,c);
            else sum(b,c);
        }

        System.out.println(sb);
    }

    // b를 c로 바꾸기
    public static void change(int b, long c) {
        int treeIdx = b + (startIdx - 1); // 트리 인덱스로 변환

        long diff = c - tree[treeIdx]; // 원래 값과 차이 구하기
        tree[treeIdx] = c; // 원래 값 바꾸기

        int temp = treeIdx / 2;
        while(temp >= 1) {
            tree[temp] += diff; // 부모 값 업데이트 (루트까지 업데이트)
            temp /= 2;
        }
    }

    // b에서 c까지 합 구하기
    public static void sum(int b, long c) {
        int bIdx = b + (startIdx - 1);
        int cIdx = (int)c +  (startIdx - 1);

        long result = 0;
        while (bIdx <= cIdx) {

            if (bIdx == cIdx) { //같으면 더하고 종료
                result += tree[bIdx];
                break;
            }
            if (bIdx % 2 == 1) {
                result += tree[bIdx];
            }
            bIdx = (bIdx+1)/2;

            if (cIdx % 2 == 0) {
                result += tree[cIdx];
            }
            cIdx = (cIdx-1)/2;
        }

        sb.append(result).append("\n");
    }
}
