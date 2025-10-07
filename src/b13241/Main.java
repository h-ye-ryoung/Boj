package b13241;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1 = sc.nextLong();
        long num2 = sc.nextLong();

        long result = num2;
        while(!(result % num1 == 0)) {
            result += num2;
        }
        System.out.println(result);
    }
}
