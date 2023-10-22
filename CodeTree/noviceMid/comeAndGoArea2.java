import java.io.*;
import java.util.*;
 
public class Main {
    static int N, answer;
    static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
        arr = new int[2001];
 
        int now = 1000; // 시작점을 아예 1000으로 설정
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
 
            if (dir == 'L') {
                // 왼쪽 이동 시 색칠 구간 : [현재 위치 - 1, 현재 위치 - 이동 크기]
                for (int i = now - 1 ; i >= now - x ; i--) {
                    arr[i] += 1;
                }
                now -= x;   // 현재 위치 업데이트
            }
            else {
                // 오른쪽 이동 시 색칠 구간 : [현재 위치, 현재 위치 + 이동 크기 - 1]
                for (int i = now; i < now + x; i++) {
                    arr[i] += 1;
                }
                now += x;   // 현재 위치 업데이트
            }
        }
 
        // 2번 이상 지나간 구간 구하기
        answer = 0;
        for(int i = 0 ; i < arr.length ; i++) {
             if(arr[i] >= 2) {
                 answer++;
             }
        }
        System.out.println(answer);
    }
}
