import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());   // 강의
        int M = Integer.parseInt(st.nextToken());   // 블루레이

        int[] arr = new int[N];
        int start = 0;  // 시작 인덱스
        int end = 0;    // 배열 총합

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; i++) { 
            arr[i] = Integer.parseInt(st.nextToken());

            if(arr[i] > start) start = arr[i];   // 레슨 최댓값을 시작 인덱스로 저장
            end += arr[i];                    // 모든 레슨의 총합을 종료 인덱스로 저장
        }

        while(start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int cnt = 0;

            // mid 값으로 모든 레슨 저장할 수 있는지 확인
            for(int i = 0 ; i < N ; i++) {
                if(sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if(sum != 0)
                cnt++;
            if(cnt > M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start);
    }
}