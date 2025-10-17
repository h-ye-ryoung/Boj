package b1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] array;

    public static void main(String[] args) throws IOException    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        array = new int[N+1];
        for (int i = 0; i <= N; i++) { //배열 초기화
            array[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            if (num1 == 0) { //0이면 union
                union(num2, num3);
            } else { //1이면 find 해서 루트노드가 같은지 확인
                int a = find(num2);
                int b = find(num3);
                if (a==b) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    //대표노드 찾는 연산
    private static int find(int num) {
        if(num == array[num]) {
            return num;
        } else {
            int a = find(array[num]); //재귀
            array[num] = a; //재귀 빠져나올 때 루트노드를 값으로 세팅
            return a;
        }
    }

    // 더 작은 수가 루트 노드가 되게
    private static void union(int a, int b) {
        int n1 = find(a);
        int n2 = find(b);
        if (n1 < n2) array[n2] = n1;
        else array[n1] = n2;
    }
}
