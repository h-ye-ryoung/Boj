package b12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken()); //문자열 총 길이
        int partLength = Integer.parseInt(st.nextToken()); //부분문자열 길이

        String DNAString = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] checkArray = new int[4]; //A,C,G,T 각각의 최소 필요수를 받아와서 checkArray 배열 채우기
        for (int i = 0; i < 4; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());
        }

        char[] S = DNAString.toCharArray(); // 전체 DNAString 문자 -> char 배열로 변환

        int[] currentArray = new int[4]; //currentArray -> 부분문자열의 A,C,G,T 개수를 담는 배열 선언
        int count = 0;

        //최초 부분문자열의 currentArray 채우기
        for (int i = 0; i < partLength; i++) {
            if (S[i] == 'A') currentArray[0]++;
            else if (S[i] == 'C') currentArray[1]++;
            else if (S[i] == 'G') currentArray[2]++;
            else currentArray[3]++;
        }
        //currentArray를 가지고 최초 부분문자열의 조건 검사 - true면 count++
        if (checkArray[0] <= currentArray[0] && checkArray[1] <= currentArray[1]
            && checkArray[2] <= currentArray[2] && checkArray[3] <= currentArray[3]) {
            count++;
        }

        int i = 0; //여기까지 마친 후, 현재 부분문자열의 맨 왼쪽 인덱스
        int j = partLength-1; //현재 부분문자열의 맨 오른쪽 인덱스

        //앞에서 최초 배열을 검사한 횟수 제외하고, 나머지 횟수만큼 반복하기
        for (int k = 0; k < length-partLength; k++) {
            if (S[i] == 'A') currentArray[0]--;
            else if (S[i] == 'C') currentArray[1]--;
            else if (S[i] == 'G') currentArray[2]--;
            else currentArray[3]--;
            i++; //i에 해당하는 문자의 횟수 빼주고 i++
            j++; //j++하고 j에 해당하는 문자의 횟수 더해줌 (윈도우 이동 끝)
            if (S[j] == 'A') currentArray[0]++;
            else if (S[j] == 'C') currentArray[1]++;
            else if (S[j] == 'G') currentArray[2]++;
            else currentArray[3]++;

            //윈도우 이동&currentArrray 변경 후, 부분문자열 조건 검사 -> true면 count++
            if (checkArray[0] <= currentArray[0] && checkArray[1] <= currentArray[1]
                    && checkArray[2] <= currentArray[2] && checkArray[3] <= currentArray[3]) {
                count++;
            }
        }

        System.out.print(count);
    }
}