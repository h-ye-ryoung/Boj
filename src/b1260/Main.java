package b1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N; //노드
    static int E; //엣지
    static List<Integer>[] graph;
    static boolean[] V; //방문 배열
    static List<Integer> resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        resultArr = new ArrayList<>();

        // 그래프 초기화
        graph = new ArrayList[N+1]; //노드가 1부터 시작하므로
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프에 데이터 담기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 각각에 딸린 노드들을 오름차순으로 정렬
        // 이렇게 하면 DFS나 BFS 했을 때 오름차순으로 순회할 수 있다.
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        V = new boolean[N+1]; //방문 배열 초기화
        DFS(startNode);
        //출력
        printArray();

        V = new boolean[N+1]; //방문 배열 초기화
        resultArr.clear(); //결과 배열 초기화
        BFS(startNode);
        //출력
        printArray();
    }

    private static void BFS(int startNode) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode); //첫 번째 노드 큐에 추가
        V[startNode] = true; //첫번째 노드 방문 처리
        resultArr.add(startNode); //첫번째 노드 결과배열에 추가

        //큐가 빌 때까지 BFS 진행
        while(!queue.isEmpty()) {
            int temp = queue.poll(); //큐에서 뽑아서

            //temp 노드에 딸린 모든 자식 노드들 탐색
            for (int node : graph[temp]) {
                if (!V[node]) { //아직 방문 안한 노드에 한해서
                    V[node] = true; //자식 노드 방문 배열 체크
                    queue.add(node); //큐에 넣기
                    resultArr.add(node); //정답 배열에 넣기
                }
            }
        }
    }

    private static void DFS(int node) {

        V[node] = true; //현재 노드 방문 처리
        resultArr.add(node); //결과 배열에 넣기

        // 매개로 받은 node의 모든 자식 순회
        for (int n : graph[node]) {
            //아직 방문하지 않은 노드라면
            if (!V[n]) {
                DFS(n); //재귀 호출
            }
        }
    }

    private static void printArray() {
        for (int i : resultArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
