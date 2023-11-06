import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 인접하지 않은 모든 쌍에 대해 완전 탐색
        int max = 0;
        for(int i = 0 ; i < N - 1 ; i++) {
            for(int j = i + 2 ; j < N ; j++) {
                max = Math.max(max, arr[i] + arr[j]);
            }
        }
        
        System.out.println(max);
    }
}
