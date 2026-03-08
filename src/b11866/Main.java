package b11866;

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
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> result = new ArrayList<>(); //정답 배열
        boolean[] visited = new boolean[N+1]; //방문 배열

        int index = 0;
        while (result.size() < N) {
            int temp = 0; //유효 인덱스 카운트
            while (temp < K) { //유효할 때까지 K번 인덱스 증가
                if (index+1 > N) { //다음 인덱스가 범위를 넘어갔을 때 돌아오게 (원형구조)
                    index -= N;
                }
                if (!visited[index+1]) { //다음 게 방문 안한 수면 유효 카운트 증가 & 인덱스 증가
                    temp++;
                    index++;
                } else {
                    index++; //방문한 수면 인덱스만 증가
                }
            }
            // K번 인덱스 증가되었을 때
            result.add(index);
            visited[index] = true;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N-1; i++) {
            sb.append(result.get(i)).append(", ");
        }
        sb.append(result.get(N-1)).append(">");

        System.out.println(sb);
    }
}
