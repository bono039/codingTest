import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());   // 총 개수
		int K = Integer.parseInt(st.nextToken());   // 선택 개수
		
		int[][] D = new int[N+1][N+1];  // 조합 배열
		
		// 배열 초기화
		for(int i=0 ; i <= N ; i++) {
		    D[i][0] = 1;
		    D[i][1] = i;
		    D[i][i] = 1;
		}
		
		// 점화식으로 배열 완성
		for(int i=2 ; i <= N ; i++) {
		    for(int j=1 ; j < i ; j++) {
		        D[i][j] = D[i-1][j] + D[i-1][j-1];
		    }
		}
		
		System.out.println(D[N][K]);
	}
}