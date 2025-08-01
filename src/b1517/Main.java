package b1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long count = 0; // 역전하는 (swap하는) 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        mergeSort(array, left, right);

        System.out.print(count);
    }

    public static void mergeSort(int[] array, int left, int right) {

        if (left >= right) return; //최소 단위가 되면 리턴..

        int mid = (left+right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, right, mid);
    }

    public static void merge(int[] array, int left, int right, int mid) {
        int[] result = new int[right-left+1]; //결과 배열
        int leftPointer = left; //왼쪽 그룹의 포인터
        int rightPointer = mid+1; //오른쪽 그룹의 포인터

        int i = 0;
        while (leftPointer <= mid && rightPointer <= right ) { //어느 하나가 마지막에 도달할 때까지
            if (array[leftPointer] <= array[rightPointer]) {
                result[i] = array[leftPointer];
                leftPointer++;
                i++;
            } else {
                result[i] = array[rightPointer];
                rightPointer++;
                i++;
                count += mid - leftPointer + 1;
            }
        }

        while (leftPointer <= mid) { //왼쪽 그룹에 수가 남았으면
            result[i] = array[leftPointer];
            i++;
            leftPointer++;
        }

        while (rightPointer <= right) { //오른쪽 그룹에 수가 남았으면
            result[i] = array[rightPointer];
            i++;
            rightPointer++;
        }

        // 두 그룹이 정렬됐으면 기존 array에 덮어씌워주기
        int k = 0;
        for (int j = left; j <= right; j++) {
            array[j] = result[k];
            k++;
        }
    }
}
