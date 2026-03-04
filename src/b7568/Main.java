package b7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        D[] array = new D[N]; //덩치 저장 배열

        for (int i = 0; i < N; i++) { //덩치 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = new D();
            array[i].weight = Integer.parseInt(st.nextToken());
            array[i].height = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) { //나 = i
            int count = 0;
            for (int j = 0; j < N; j++) { //나보다 덩치 큰 사람이 N명 있으면 -> 나는 N+1등
                if (array[i].weight < array[j].weight && array[i].height < array[j].height) {
                    count++;
                }
            }
            result[i] = count + 1; //내 등수
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static class D {
        int weight;
        int height;
    }
}
