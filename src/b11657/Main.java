package b11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_000_000;

    public static class Edge {
        int start;
        int end;
        int weight;

        Edge(int s, int e, int w) {
            this.start = s;
            this.end = e;
            this.weight = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edgeArr = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeArr[i] = new Edge(s, e, w);
        }

        int[] resultArr = new int[V+1];
        resultArr[1] = 0;
        for (int i = 2; i <= V; i++) {
            resultArr[i] = MAX;
        }

        for (int i = 1; i <= V-1 ; i++) { //V-1번 반복
            int[] resultArrCopy = resultArr.clone();

            for (Edge edge : edgeArr) { //모든 엣지에 대해
                if (resultArrCopy[edge.start] != MAX // resultArr 카피본(이전 형상)을 보고 검사한다. 원본은 검사 중에 계속 업데이트되기 때문
                    && resultArrCopy[edge.start] + edge.weight < resultArrCopy[edge.end]) {
                    resultArr[edge.end] = resultArr[edge.start] + edge.weight; //조건에 맞으면 업데이트
                }
            }
        }

        // 마지막 한번 더 반복
        int[] resultArrCopy = resultArr.clone(); //카피본

        for (Edge edge : edgeArr) { //모든 엣지에 대해
            if (resultArrCopy[edge.start] != MAX
                    && resultArrCopy[edge.start] + edge.weight < resultArrCopy[edge.end]) {
                resultArr[edge.end] = resultArr[edge.start] + edge.weight; //조건에 맞으면 업데이트
            }
        }

        // 이전 상태 카피본과 원본이 다르면 -1 출력
        boolean isChanged = false;
        for (int i = 1; i < V+1; i++) {
            if (resultArr[i] != resultArrCopy[i]) {
                isChanged = true;
                System.out.print(-1);
                break;
            }
        }

        // 아니면 resultArr 출력 (이때 MAX값이 있으면 그 값은 -1로 출력)
        // 1번은 시작 노드니까 2번부터 출력
        if (!isChanged) {
            for (int i = 2; i < V+1; i++) {
                if (resultArr[i] == MAX) System.out.println(-1);
                else System.out.println(resultArr[i]);
            }
        }
    }
}