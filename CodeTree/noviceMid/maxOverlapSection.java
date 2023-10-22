import java.util.*;
import java.io.*;
 
public class Main {
    static int N, cnt;
    static int[] arr = new int[201];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
 
        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
 
            for(int i = x1 ; i < x2 ; i++) {  // 겹치는 지점은 x1 ~ x2 - 1까지
                arr[i + 100] += 1;  // 음수 구간에 대한 OFFSET 필요
                cnt = Math.max(cnt, arr[i + 100]);
            }
        }
 
        System.out.println(cnt);
    }
}
