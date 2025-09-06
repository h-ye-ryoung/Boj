package b1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] array;
    static char[] resultArray;
    static int passwordLength;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        passwordLength = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        array = new char[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) { // 주어진 배열 받아오기
            array[i] = st.nextToken().charAt(0);
        }
        resultArray = new char[passwordLength]; //배열 초기화

        // 알파벳 순으로 정렬
        Arrays.sort(array);

        backTracking(0, 0);
    }

    private static void backTracking(int depth, int index) {

        // 정답 처리 - 원하는 길이에 도달하면
        if(depth == passwordLength) {
            //최소 한개의 모음(aeiou)과 최소 두개의 자음이 보장될 때만 출력
            if (check()) {
                for (int i = 0; i < passwordLength; i++) {
                    System.out.print(resultArray[i]);
                }
                System.out.println();
                return;
            } else {
                return;
            }
        }

        // 정답이 아니라면, 가능한 모든 문자를 순회
        // 이때 사전식으로 출력해야 하므로 (역순x), 인자로 받은 index부터 순회돌기 시작
        for (int i = index; i < length; i++) {
            //if () {
                resultArray[depth] = array[i]; // 정답 배열의 현재 depth번째 칸에, array의 (지금 순회도는 배열) i번째 인덱스의 문자 저장
                backTracking(depth+1, i+1); // 다음 재귀호출
            //}
        }
    }


    // 모음 최소 1개, 자음 최소 2개일 경우 true
    private static boolean check() {
        int aeio = 0; // 모음 개수
        int w = 0; // 자음 개수
        for (int i = 0; i < passwordLength; i++) {
            switch (resultArray[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    aeio++;
                    break;
                default:
                    w++;
                    break;
            }
        }
        if (aeio >= 1 && w >=2 ) return true;
        else return false;
    }
}
