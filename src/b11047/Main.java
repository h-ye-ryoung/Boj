package b11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //10
        int K = Integer.parseInt(st.nextToken()); //4200
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine()); //1 5 10 50...
        }

        int count = 0;
        int index = N-1;
        while (K > 0) {
            if (K < array[index]) {
                index--;
            } else {
                K -= array[index];
                count += 1;
            }
        }

        System.out.println(count);
    }
}
