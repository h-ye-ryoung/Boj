package b1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        float[] array = new float[n];

        float max = 0;
        for (int i = 0; i < n; i++) {
            array[i] = Float.parseFloat(st.nextToken());
            if (array[i] > max) {
                max = array[i];
            }
        }

        float all = 0;
        for (int i = 0; i < n; i++) {
            float abc = array[i]/max*100;
            all += abc;
        }

        float avg = all/n;
        System.out.println(avg);

    }
}
