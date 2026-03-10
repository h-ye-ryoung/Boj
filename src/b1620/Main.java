package b1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //입력 -> map으로 받기 (숫자를 key로)
        Map<Integer, String> mapInt = new HashMap<>();
        for (int i = 1; i <= N; i++) {
           mapInt.put(i, br.readLine());
        }
        //문자를 key로 한 map 또 생성
        Map<String, Integer> mapString = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            mapString.put(mapInt.get(i), i);
        }

        //문제
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine(); //String 타입

            //문제를 String 타입으로 받았으므로 무작정 int 변경 X,먼저 value에 있는 String 값인지 확인
            if (mapString.containsKey(question)) {
                sb.append(mapString.get(question)).append("\n");
            } else { //String에 없으면 숫자인걸로
                int num = Integer.parseInt(question);
                sb.append(mapInt.get(num)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
