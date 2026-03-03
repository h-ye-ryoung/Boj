package b1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) { //배열에 담기
            set.add(br.readLine());
        }

        String[] array = new String[set.size()];
        array = set.toArray(array);
        Arrays.sort(array); //알파벳 정렬

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 1; i <= 50; i++) { //길이 짧은 것부터 순서대로 담기 (1~50)
            for (String s : array) {
                if (s.length() == i) {
                    arrayList.add(s);
                }
            }
        }

        for (String s : arrayList) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
