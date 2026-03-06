package b10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Member> array = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array.add(new Member());
            array.get(i).age = Integer.parseInt(st.nextToken());
            array.get(i).name = st.nextToken();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 200; i++) {
            for (int j = 0; j < N; j++) {
                if (array.get(j).age == i) {
                    sb.append(array.get(j).age).append(" ").append(array.get(j).name).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static class Member {
        int age;
        String name;
    }
}