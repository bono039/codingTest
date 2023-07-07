import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] strArr = new String[N][2];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            strArr[i][0] = st.nextToken();
            strArr[i][1] = st.nextToken();
        }
        
        for(int i = 0 ; i < M ; i++) {
            int find = Integer.parseInt(br.readLine());
            
            int left = 0;
            int right = N - 1;
            int mid = (left + right) / 2;
            
            while(left <= right) {
                mid = (left + right) / 2;
                
                int arrNum = Integer.parseInt(strArr[mid][1]);
                if(arrNum < find) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            
            sb.append(strArr[left][0]).append("\n");
        }
        
        System.out.println(sb);
    }
}
