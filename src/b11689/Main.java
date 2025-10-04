package b11689;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N; //서로소가 될 수 있는 모든 후보의 수

        for (long i = 2; i <= Math.sqrt(N); i++) { //2부터 N의 제곱근까지
            if (N % i == 0) {
                result -= result/i; //i의 배수가 N이라면, 서로소 아니므로 그 숫자만큼 빼주기
                while (N % i == 0) {
                    N = N/i; //i의 다음 배수들 차례가 왔을 때 나누어지지 않도록 끝까지 나눠주기 (i로 소인수분해)
                }
            }
        }

        //반복문 종료 후 N이 1보다 크다면 해당 N이 마지막 소인수라는 뜻!
        if (N>1) {
            result -= result/N; //result값을 마지막으로 업데이트한다.
        }

        System.out.print(result);
    }
}
