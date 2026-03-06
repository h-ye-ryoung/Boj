package b4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String st = br.readLine();
            if (st.equals(".")) break; //종료 조건

            Stack<Character> stack = new Stack<>();
            boolean result = true; //판단 플래그
            char[] array = st.toCharArray(); //문자 배열로 변환

            for (char ch : array) {
                if (ch == '.') break; //종료 조건
                if (ch == '(' || ch == '[') {
                    stack.add(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) { //스택 비었을 때 처리
                        result = false;
                        break;
                    } else {
                        char temp = stack.pop();
                        if (temp != '(') {
                            result = false;
                            break;
                        }
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty()) { //스택 비었을 때 처리
                        result = false;
                        break;
                    } else {
                        char temp = stack.pop();
                        if (temp != '[') {
                            result = false;
                            break;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                result = false;
            }

            if (!result) {
                sb.append("no").append("\n");
            } else {
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);
    }
}
