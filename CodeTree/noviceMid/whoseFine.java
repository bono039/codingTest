import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   // 학생 수
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());   // K번 이상 벌칙 받으면 벌금

        int[] arr = new int[N + 1];
        int answer = -1;

        while(M --> 0) {
            int num = Integer.parseInt(br.readLine());

            arr[num]++;

            if(arr[num] == K) {
                answer = num;
                break;
            }
        }

        System.out.println(answer);
    }
}
