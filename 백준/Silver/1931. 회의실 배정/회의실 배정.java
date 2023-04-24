import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][2];
		
		
		for(int i = 0 ; i < N ; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    A[i][0] = Integer.parseInt(st.nextToken());
		    A[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 종료 시간 기준 정렬
		Arrays.sort(A, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] S, int[] E) {
		        // 종료 시간이 같으면
		        if(S[1] == E[1]) {
		            return S[0] - E[0];
		        }
		        return S[1] - E[1];
		    }
		});
		
		int cnt = 0;
		int end = -1;
		for(int i = 0 ; i < N ; i++) {
		    // 겹치지 않는 경우. 종료 시간 업데이트
		    if(A[i][0] >= end) {    
		        end = A[i][1];
		        cnt++;
		    }
		}
		
		System.out.println(cnt);
	}
}