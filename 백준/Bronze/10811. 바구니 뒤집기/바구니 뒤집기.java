import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0 ; i < arr.length ; i++) {
        	arr[i] = i+1;
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 역순으로 뒤집기
            for(int j = 0 ; j < (to - from + 1) / 2 ; j++) {
                int tmp = arr[from -1 + j];
                arr[from -1 + j] = arr[to -1 - j];
                arr[to -1 - j] = tmp;		        
            }
        }

        for(int i : arr) {
        	System.out.print(i + " ");
        }
    }
}