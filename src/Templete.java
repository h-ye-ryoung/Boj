import java.io.*;
import java.util.*;

// 혜령이를 위한 백준 템플릿
public class Templete {
    // 전역 변수 선언 - ex. 특정 함수가 실행된 개수 등
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 한줄에 하나씩 입력 받아야 될 때
        int N = Integer.parseInt(br.readLine());

        // 한줄에 띄어쓰기로 여러개 받아야 될 때 - 1 2 3 4 5 입력 시 nextToken() 때 마다 하나씩 읽음.
        // 아래의 경우 nextToken()을 6번 쓴다면 예외 발생
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] array = new int[N];
        for(int i = 0; i < N; i++)array[i] = Integer.parseInt(st.nextToken());

        // 하나 출력
        System.out.print("혜령이는 귀여워");

        // 여러개 출력 - ex. 띄어쓰기로 구분해서 출력하기.
        for(int i = 0; i < N; i++){
            sb.append(array[i]).append(" ");
        }

        System.out.print(sb); // sb 꼭 출력해야돼!
    }
    // 전역 함수 선언(함수를 써야할 때)
    static void utils() {
    }
}
