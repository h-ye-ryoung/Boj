package b11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Xy[] array = new Xy[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = new Xy();
            array[i].x = Integer.parseInt(st.nextToken());
            array[i].y = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, new Comparator<Xy>() {
            @Override
            public int compare(Xy o1, Xy o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(array[i].x).append(" ").append(array[i].y).append("\n");
        }

        System.out.println(sb);
    }

    public static class Xy {
        int x;
        int y;
    }
}
