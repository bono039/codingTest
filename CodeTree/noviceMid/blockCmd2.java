import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] block;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        block = new int[N + 1];

        while(K --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i = a ; i <= b ; i++) {
                block[i] += 1;
                answer = Math.max(answer, block[i]);
            }
        }

        System.out.println(answer);
    }
}
