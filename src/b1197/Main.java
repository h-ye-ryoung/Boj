package b1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] uf;

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        Edge(int s, int e, int w) {
            this.start = s;
            this.end = e;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // PQ로 엣지 저장과 동시에 가중치 기준 엣지 정렬
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, w));
        }

        // 유니온 파인드 배열 생성 & 초기화
        uf = new int[V+1];
        for (int i = 1; i < V+1; i++) {
            uf[i] = i;
        }

        int count = 0; //지금까지 선택한 엣지 수
        int result = 0; //지금까지 누적된 엣지 가중치

        while(count <= V-1 && !pq.isEmpty()) { //엣지 수가 V-1개를 넘거나 pq가 비면 빠져나온다.
            Edge edge = pq.poll(); //제일 가중치 적은 엣지 뽑기
            int root1 = find(edge.start);
            int root2 = find(edge.end);
            if (root1 != root2) { //연결되어있지 않으면
                union(root1, root2);
                count++;
                result += edge.weight;
            }
        }

        System.out.println(result);
    }

    public static int find(int node) {
        if (uf[node] == node) {
            return node;
        } else {
            uf[node] = find(uf[node]);
            return uf[node];
        }
    }

    public static void union(int a, int b) { //루트노드 2개
        if(a<b) uf[b] = a;
        else uf[a] = b;
    }
}
