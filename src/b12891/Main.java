package b12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int partLength = Integer.parseInt(st.nextToken());

        String DNAString = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] targetArray = new int[4]; //A,C,G,T 만족시켜야 하는 최소수
        for (int i = 0; i < 4; i++) {
            targetArray[i] = Integer.parseInt(st.nextToken());
        }

        char[] S = DNAString.toCharArray(); // 전체 DNAString 문자 배열

        int[] currentArray = new int[4]; //현재 윈도우의 A,C,G,T 개수
        int count = 0;

        //최초의 윈도우 배열 검사
        for (int i = 0; i < partLength; i++) {
            if (S[i] == 'A') currentArray[0]++;
            else if (S[i] == 'C') currentArray[1]++;
            else if (S[i] == 'G') currentArray[2]++;
            else currentArray[3]++;
        }

        //검사
        if (targetArray[0] <= currentArray[0] && targetArray[1] <= currentArray[1]
            && targetArray[2] <= currentArray[2] && targetArray[3] <= currentArray[3]) {
            count++;
        }

        int i = 0;
        int j = partLength-1;
        for (int k = 0; k < length-partLength; k++) { //앞에서 최초 배열을 검사한 횟수 제외
            if (S[i] == 'A') currentArray[0]--;
            else if (S[i] == 'C') currentArray[1]--;
            else if (S[i] == 'G') currentArray[2]--;
            else currentArray[3]--;
            i++; //i에 해당하는 문자 횟수 빼주고 i++
            j++; //j++하고 j에 해당하는 문자 더해줌 (윈도우 이동 끝)
            if (S[j] == 'A') currentArray[0]++;
            else if (S[j] == 'C') currentArray[1]++;
            else if (S[j] == 'G') currentArray[2]++;
            else currentArray[3]++;

            //검사
            if (targetArray[0] <= currentArray[0] && targetArray[1] <= currentArray[1]
                    && targetArray[2] <= currentArray[2] && targetArray[3] <= currentArray[3]) {
                count++;
            }
        }

        System.out.print(count);
    }
}