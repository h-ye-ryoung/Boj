package b11720;

import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int number = Integer.parseInt(br.readLine());

                String str = br.readLine();

                int sum = 0;
                for (int i = 0; i < number; i++) {
                        sum += str.charAt(i) - '0';
                }

                System.out.println(sum);
        }
}
