package b2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 1;
        int result = 1; // right==n일 경우

        int left = 1;
        int right = 1;
        while (right != n) {
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else {
                result += 1;
                right++;
                sum += right;
            }
        }

        System.out.print(result);
    }
}
