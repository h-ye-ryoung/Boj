package b1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 인접 그래프
        ArrayList<Integer[]>[] array = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            array[i] = new ArrayList<>();
        }

        // 그래프 받아오기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[2]; // [도착 노드, 가중치]
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            array[a].add(arr);
        }

        // 최단경로 배열 초기화
        int[] result = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[start] = 0;

        // 방문 배열 초기화
        boolean[] visit = new boolean[V+1];

        while(true) {
            int minVertex = 0;
            // 최단경로 배열 중 아직 방문하지 않았으면서 & 가장 작은 값을 가진 vertex 찾기
            for (int i = 1; i <= V; i++) {
                if (result[i] < result[minVertex] && !visit[i]) { //이때 result[0]은 항상 max_value로 세팅되어있음
                    minVertex = i;
                }
            }
            if (minVertex == 0) break; //모든 노드 방문했으면 탐색 종료

            // 선택 노드 방문 처리하고, 딸린 노드들 탐색하며 최단경로 업데이트
            visit[minVertex] = true;
            for(Integer[] temp : array[minVertex]) {
                // 딸린 노드의 원래 최단경로보다 현재 계산한 경로가 작으면 -> 업데이트
                if (result[minVertex] + temp[1] < result[temp[0]]) {
                    result[temp[0]] = result[minVertex] + temp[1];
                }
            }
        }

        // 출력
        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(result[i]);
        }

    }
}
