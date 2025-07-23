package b11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n+1];
        int[] sum = new int[n+1];

        st = new StringTokenizer(br.readLine()); // st 갱신 필요
        array[0] = 0;
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + array[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int result = sum[l] - sum[k-1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
