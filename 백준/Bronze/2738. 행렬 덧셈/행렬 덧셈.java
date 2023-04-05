import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        
        for(int k = 0 ; k < 2 ; k++) {
            for(int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                for(int j = 0 ; j < M ; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] += num;
                }
            }            
        }
        
		for(int i = 0 ; i < N ; i++) {
		    for(int j = 0 ; j < M ; j++) {
		        System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}
	}
}