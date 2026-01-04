package b10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1_000_000_001;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 트리 만들기
        int k2 = 1;
        while (k2 < N) {
            k2 <<= 1; //N보다 커질 때까지 2^k 계산
        }
        int size = k2 << 1; //트리 크기
        int[] tree = new int[size];
        Arrays.fill(tree, MAX);

        // 리프 노드에 값 넣기
        for (int i = k2; i < k2+N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        // 나머지 노드에 최소값 넣기
        for (int i = size-1; i >= 2; i--) {
            if (tree[i/2] > tree[i]) tree[i/2] = tree[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aIdx = a + k2 - 1;
            int bIdx = b + k2 - 1;

            int result = MAX; //최솟값
            while (aIdx <= bIdx) {
                if (aIdx == bIdx) {
                    if (result > tree[aIdx]) result = tree[aIdx];
                    break;
                }
                if (aIdx % 2 ==1) {
                    if (result > tree[aIdx]) result = tree[aIdx];
                }
                aIdx = (aIdx + 1)/2;
                if (bIdx % 2 == 0) {
                    if (result > tree[bIdx]) result = tree[bIdx];
                }
                bIdx = (bIdx-1)/2;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}