package b1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] array = new int[30][30]; //mCn 저장 배열

        for (int m = 1; m < 30; m++) { //n==0, n==1, n==m일때 초기화
            array[m][0] = 1;
            array[m][m] = 1;
            array[m][1] = m;
        }

        for (int m = 1; m < 30; m++) {
            for (int n = 2; n < m; n++) {
                array[m][n] = array[m-1][n] + array[m-1][n-1];
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M =  Integer.parseInt(st.nextToken());
            System.out.println(array[M][N]); //mCn 구하기
        }
    }
}
