package b2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] array;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        // 리스트 초기화
        array = new ArrayList[vertex+1];
        for (int i = 1; i < vertex+1; i++) {
            array[i] = new ArrayList<>();
        }

        // 그래프 -> 인접리스트
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            array[v1].add(v2);
            array[v2].add(v1);
        }

        count = 0;
        visit = new boolean[vertex+1];
        visit[1] = true;
        DFS(1);

        System.out.println(count);
    }

    public static void DFS(int v) {
        for (int i : array[v]) {
            if(!visit[i])  {
                visit[i] = true;
                count++;
                DFS(i);
            }
        }
    }
}
