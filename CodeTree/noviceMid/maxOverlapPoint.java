import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[101];

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int i = x1 ; i <= x2 ; i++) {   // 겹치는 지점 구하기 : x1 ~ x2 !
                arr[i] += 1;
            }
        }

        // 최대 선분 갯수 구하기
        for(int i : arr) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
