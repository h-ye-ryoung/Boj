package b1427;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 각 자리수를 잘라서 담은 배열 만들기
        char[] charArray = sc.next().toCharArray();

        // 오름차순 정렬 (char 배열 그대로 정렬)
        Arrays.sort(charArray);

        // 거꾸로 출력하기
        for (int i = charArray.length-1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
    }
}
