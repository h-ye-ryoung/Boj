package b1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        ArrayList<Integer>[] array = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            array[i] = new ArrayList<>();
        }

        int root = 0; //루트 노드
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == -1) {
                root = i;
                continue;
            }
            array[temp].add(i);
        }

        int target = Integer.parseInt(br.readLine());

        if (target == root) {
            System.out.println(0);
        } else {
            // 모든 노드 순회하며, 타겟을 가진 부모 노드를 찾아 타겟을 삭제
            for (int i = 0; i < N; i++) {
                if (array[i].contains(target)) {
                    array[i].remove(Integer.valueOf(target));
                    break;
                }
            }

            // 루트 노드부터 돌면서 BFS로 자식 없는 노드 찾기
            // 타겟은 트리에서 끊겼으므로 타겟을 루트로 한 서브트리는 순회 안 될 것...!
            int result = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (array[node].isEmpty()) { // 자식 노드가 없으면 리프노드 +1
                    result += 1;
                } else {
                    for(int n : array[node]) {
                        queue.add(n);
                    }
                }
            }

            System.out.println(result);
        }
    }
}
