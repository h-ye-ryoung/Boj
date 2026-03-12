package b1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> array = new ArrayList<>();
        Set<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) { //듣도 못한
            array.add(br.readLine());
        }
        for (int i = 0; i < M; i++) { //보도 못한
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String string : array) {
            if (set.contains(string)) {
                result.add(string);
                count++;
            }
        }
        Collections.sort(result);
        for (String str : result) {
            sb.append(str).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
