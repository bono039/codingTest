import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[10][10];
        int max = 0;
        
        int aIdx = 0;
        int bIdx = 0;

        for(int i = 1 ; i < 10 ; i++) {
            var st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 1 ; j < 10 ; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                
                if(arr[i][j] >= max) {
                    max = arr[i][j];
                    
                    aIdx = i;
                    bIdx = j;
                }
            }            
        }

        System.out.println(max);
        System.out.println(aIdx + " " + bIdx);
	}
}