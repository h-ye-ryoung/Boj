package b1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] question = br.readLine().split("-");
        int result = 0;

        result += sum(question[0]);

        for (int i = 1; i < question.length; i++) {
            result -= sum(question[i]);
        }

        System.out.println(result);
    }

    static int sum(String st) {
        String[] temp = st.split("\\+");
        int ret = 0;
        for (String s : temp) {
            ret += Integer.parseInt(s);
        }
        return ret;
    }
}
