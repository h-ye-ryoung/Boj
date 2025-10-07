package b1850;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long num1 = sc.nextLong();
        long num2 = sc.nextLong();

        long result = num1;
        while (!(num2 % num1 == 0)) {
            result = num2 % num1;
            num2 = num1;
            num1 = result;
        }

        for (int i = 0; i < result; i++) {
            sb.append(1);
        }
        System.out.println(sb);

    }
}
