package b6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int[] resultArray; //정답 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =  Integer.parseInt(st.nextToken());
            if (N == 0) break; //0이면 반복 종료

            array = new int[N];
            resultArray = new int[6];
            for (int i = 0; i < N; i++) { //배열 받아오기
                array[i] = Integer.parseInt(st.nextToken());
            }

            backtrack(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 매개변수 : 6개중 몇번째 수를 넣고 있는지
    private static void backtrack(int depth, int index) {

        // 정답일 때
        if(depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(resultArray[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 정답이 아니라면 - 가능한 모든 경로 탐색
        // 이때 이미 고른 것보다 뒤쪽만 탐색해야 함 (오름차순 & 중복x 보장)
        for (int i = index; i < array.length; i++) {
            resultArray[depth] = array[i];
            backtrack(depth + 1, i+1 );
        }
    }
}