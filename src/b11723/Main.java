package b11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String question = st.nextToken();

            if (question.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            } else if (question.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                }
            } else if (question.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (question.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (question.equals("all")) {
                set = new HashSet<>();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (question.equals("empty")) {
                set = new HashSet<>();
            }
        }

        System.out.println(sb);
    }
}