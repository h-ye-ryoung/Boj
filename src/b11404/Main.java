package b11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int[][] array = new int[V+1][V+1]; //인접 행렬

        //인접 행렬 초기화
        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                if (i==j) array[i][j] = 0;
                else array[i][j] = MAX;
            }
        }

        //그래프 정보 넣기
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            array[start][end] = Math.min(array[start][end], weight);
        }

        //플로이드-워셜
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    array[i][j] = Math.min(array[i][j], array[i][k]+array[k][j]);
                }
            }
        }

        //출력
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (array[i][j] == MAX) System.out.print(0 + " ");
                else System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
