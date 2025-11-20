package b2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 배열 초기화
        ArrayList<Integer>[] array = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            array[i] = new ArrayList<>();
        }

        // 그래프 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a].add(b);
        }

        // 진입차수 배열 초기화
        int[] V = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            for (int num : array[i]) {
                V[num]++;
            }
        }
        // 정렬 배열 초기화
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) { //N번 반복 (N개 정렬)
            for(int j = 1; j < N+1; j++) { //노드 1~N까지 순회하며 진입차수가 0인 노드 찾기
                if(V[j] == 0) {
                    result.add(j); //먼저 줄세우기
                    for(int k : array[j]) V[k]--; //해당 노드에 연결된 노드들의 진입차수 -1
                    V[j] = -1; //또다시 탐지되지 않도록, 이미 줄세운 노드 -1로 바꾸기
                    break; //순회 끝
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
