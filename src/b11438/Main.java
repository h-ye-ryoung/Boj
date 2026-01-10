package b11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static int[] depth;
    static int height;
    static int[][] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        //트리 초기화하기
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        //트리 데이터 받아오기
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        //depth 배열
        depth = new int[N+1];
        //최대 2^k가 N일 때, 1~N 범위에서 2^k의 개수 구하기
        height = 0;
        for (int i = 1; i <= N; i*=2) {
            height++;
        }

        //Parent 배열 초기화
        P = new int[N+1][height];

        //depth, 직속 parent 채우기
        DFS(1, 0, 0);

        //나머지 배열 채우기
        treeInit();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = LCA(a, b);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int LCA(int a, int b) {

        // 항상 a depth가 더 깊게/크게 만들기. 아니라면 swap
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        //a를 b depth와 같게 끌어올리기
        for (int i = height-1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = P[a][i];
            }
        }

        //두 높이 맞췄는데 같으면 그게 LCA
        if (a==b) return a;

        //두 노드의 조상이 다를 때만 끌어올리기
        for (int i = height-1; i >= 0; i--) {
            if (P[a][i] != P[b][i]) {
                a = P[a][i];
                b = P[b][i];
            }
        }

        //여기까지 왔으면, 바로 위의 조상이 LCA
        return P[a][0];
    }

    public static void DFS(int node, int dep, int parent) {
        depth[node] = dep;
        P[node][0] = parent;

        for (int next : tree.get(node)) {
            if (next == parent) {
                continue;
            }
            DFS(next, dep+1, node);
        }
    }

    public static void treeInit() {
        for (int i = 1; i < height; i++) {
            for (int j = 1; j <= N; j++) {
                P[j][i] = P[P[j][i-1]][i-1];
            }
        }
    }
}