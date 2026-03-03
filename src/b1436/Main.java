package b1436;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String num = "666";
        int count = 0;

        while (count != N) {
            if (num.contains("666")) {
                count++;
            }
            int temp = Integer.parseInt(num) + 1;
            num = String.valueOf(temp);
        }

        int temp = Integer.parseInt(num) - 1;
        System.out.println(temp);

    }
}
