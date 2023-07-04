import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        int N, Q;
        long F[] = new long[21];    // 각 자리별로 만들 수 있는 경우의 수 저장 (팩토리얼 형태)
        int  S[] = new int[21];                 // 순열 담는 배열
        boolean visited[] = new boolean[21];    // 숫자 사용 유무 저장 배열
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine()," ");
        Q = Integer.parseInt(st.nextToken());
        
        // 팩토리얼 초기화
        F[0] = 1;
        for(int i = 1 ; i <= N ; i++) {
            F[i] = F[i - 1] * i;
        }
        
        // 1) 순열 출력 문제
        if(Q == 1) {
            long K = Long.parseLong(st.nextToken());    // 현재 순서
            
            // 팩토리얼 가짓수 치기
            for(int i = 0 ; i < N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(visited[j]) continue;
                    
                    // 주어진 K에 따라 각 자리에 들어갈 수 있는 수 찾기
                    if(F[N - i - 1] < K) {  // N : 현재 자리
                        K -= F[N - i - 1];
                    }
                    else {  // 해당하는 원소를 찾은 것
                        S[i] = j;   // 현재 자리에 j값 저장
                        visited[j] = true;
                        break;
                    }
                }
            }
            for(int i = 0 ; i < N ; i++) {
                System.out.print(S[i] + " ");
            }
        }
        // 2) 순서 출력 문제
        else {
            for(int i = 0 ; i < N ; i++) {
                S[i] = Integer.parseInt(st.nextToken());    // 순열 배열 저장
            }
            
            long ans = 1;
            
            for(int i = 0 ; i < N ; i++) {
                for(int j = 1 ; j < S[i] ; j++) {
                    // 1부터 해당하는 원소까지 팩토리얼 값 늘려가며 더하기
                    if(visited[j]) continue;
                    ans += F[N - i - 1];
                }
                visited[S[i]] = true;
            }
            System.out.println(ans);
        }
    }
}
