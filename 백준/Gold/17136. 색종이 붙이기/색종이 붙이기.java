import java.util.*;
import java.io.*;

public class Main {
    static int[] paper = {0, 5, 5, 5, 5, 5};
    
    static int[][] map = new int[10][10];
    
    static int ans = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    for(int i = 0 ; i < 10  ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < 10 ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
        dfs(0, 0, 0);
	    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	private static void dfs(int r, int c, int cnt) {
	    // 맨 끝 점 도달 시, ans와 cnt 비교 후 종료
	    if(r >= 9 && r > 9) {
	        ans = Math.min(ans, cnt);
	        return;
	    }
	    
	    if(ans <= cnt) {
	        return;
	    }
	    
	    // 아래 줄로 이동
	    if(c > 9) {
	        dfs(r + 1, 0, cnt);
	        return;
	    }
	    
	    if(map[r][c] == 1) {
	        for(int i = 5 ; i >= 1 ; i--) {
	            if(paper[i] > 0 && isAttach(r, c, i)) {
	                attach(r, c, i, 0); // 색종이 붙임
	                paper[i]--;
	                dfs(r, c + 1, cnt + 1);
	                attach(r, c, i, 1); // 색종이 다시 뗌
	                paper[i]++;
	            }
	        }
	    }
	    else {  // 오른쪽으로 이동
	        dfs(r, c + 1, cnt);
	    }
	}
	
	// 색종이 붙이는 메소드
	private static void attach(int r, int c, int size, int state) {
	    for(int i = r ; i < r + size ; i++) {
	        for(int j = c ; j < c + size ; j++) {
	            map[i][j] = state;
	        }
	    }
	}
	
	// 색종이 붙일 수 있는지 확인
	private static boolean isAttach(int r, int c, int size) {
	    for(int i = r ; i < r + size ; i++) {
	        for(int j = c ; j < c + size ; j++) {
	            if(i < 0 || i >= 10 || j < 0 || j >= 10)
	                return false;
	                
	            if(map[i][j] != 1)
	                return false;
	        }
	    }
	    
	    return true;
	}
}
