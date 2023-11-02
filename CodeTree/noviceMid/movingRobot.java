import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[1_000_001];
        int time1 = 0;
        int pos1 = 0;

        int[] B = new int[1_000_001];
        int time2 = 0;
        int pos2 = 0;

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int  t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if(d == 'L') {
                while(t --> 0) {
                    A[++time1] = --pos1;
                }
            }
            else {
                while(t --> 0) {
                    A[++time1] = ++pos1;
                }                
            }         
        }

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int  t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if(d == 'L') {
                while(t --> 0) {
                    B[++time2] = --pos2;
                } 
            }
            else {
                while(t --> 0) {
                    B[++time2] = ++pos2;
                }
            }         
        }

        // 움직임 종료 이후에는, 같은 위치에 계속 머무름
        if(time1 > time2) {
            for(int i = time2 + 1 ; i <= time1 ; i++) {
                B[i] = B[time2];
            }
        }
        else {
            for(int i = time1 + 1 ; i <= time2 ; i++) {
                A[i] = A[time1];
            }           
        }

        int cnt = 0;
        for(int i = 1 ; i <= Math.max(time1, time2) ; i++) {
            if(A[i] == B[i] && A[i -1] != B[i - 1]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
