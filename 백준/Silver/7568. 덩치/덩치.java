import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][2];
		
		// 입력 받기
		for(int i = 0 ; i < N ; i++) {
		    String[] str = br.readLine().split(" ");
		    data[i][0] = Integer.parseInt(str[0]);
		    data[i][1] = Integer.parseInt(str[1]);
		}
		
        // 등수 매기기
		for(int i = 0 ; i < N ; i++) {
            int rank = 1;

		    for(int j = 0 ; j < N ; j++) {
		        if(i == j)  continue;		        
		        if(data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
		            rank++;
		        }
		    }
		    
		    sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}
}
