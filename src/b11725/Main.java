package b11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer>[] array;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        array = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            array[i] = new ArrayList<>();
        }

        // 양방향 그래프로 넣기
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a].add(b);
            array[b].add(a);
        }

        // 부모 노드를 저장하는 배열
        parent = new int[N+1];
        // 방문 배열
        visit = new boolean[N+1];

        for (int node : array[1]) {
            visit[1] = true;
            parent[node] = 1;
            check(node);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i] + "\n");
        }

        System.out.println(sb);
    }

    public static void check(int node) {
        visit[node] = true;
        for (int n : array[node]) {
            if(!visit[n]) {
                parent[n] = node;
                check(n);
            }
        }
    }
}
