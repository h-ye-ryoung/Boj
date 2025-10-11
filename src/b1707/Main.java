package b1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] array;
    static int[] color;
    static boolean[] visit;
    static Queue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            array = new ArrayList[V+1];
            for (int j = 1; j < V+1; j++) {
                array[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                array[num1].add(num2);
                array[num2].add(num1);
            }

            boolean b = false;
            color = new int[V+1]; //1과 2로 번갈아가면서 칠할 것, 일단 1로 칠하기
            visit = new boolean[V+1];
            queue = new ArrayDeque<>();
            for (int j = 1; j <= V; j++) { //모든 정점에 대해 BFS 수행
                if (!visit[j]) {
                    color[j] = 1;
                    b = search(j);
                    if (!b) break;
                }
            }
            if (b) sb.append("YES").append("\n"); //마지막까지 true로 남으면 이분 그래프 - yes 출력
            else sb.append("NO").append("\n"); //하나라도 false이면 no
        }
        System.out.println(sb);
    }
    private static boolean search(int i) {
        queue.add(i);
        visit[i] = true;
        while(!queue.isEmpty()) {
            int num = queue.poll();
            for (int temp : array[num]) {
                if (color[num] == color[temp]) {
                    return false; //이분 그래프가 아니면 f 반환
                } else {
                    if(color[num] == 1) color[temp] = 2;
                    else color[temp] = 1;
                }
                if (!visit[temp]) {
                    visit[temp] = true;
                    queue.add(temp);
                }
            }
        }
        return true; //모두 성공하면 이분 그래프이므로 true 반환
    }
}
