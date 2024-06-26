import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 0 ; j < N ; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		dfs(0);
		System.out.println(answer);
	}
	
	private static void dfs(int cnt) {
	    if(cnt == 5) {
	        findMax();
	        return;
	    }
	    
	    int[][] copy = copyArray(map);
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        move(d);
	        dfs(cnt + 1);
	        
	        map = copyArray(copy);
	    }
	}
	
	private static int[][] copyArray(int[][] arr) {
	    int[][] tmp = new int[N][N];
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            tmp[i][j] = arr[i][j];
	        }
	    }
	    return tmp;
	}
	
	private static void move(int dir) {
	    switch(dir) {
	        case 0:
	            for(int i = 0 ; i < N ; i++) {
	                int idx = 0;
	                int block = 0;
	                
	                for(int j = 0 ; j < N ; j++) {
	                    if(map[j][i] != 0) {
	                        if(block == map[j][i]) {
	                            map[idx - 1][i] = block * 2;
	                            block = 0;
	                            map[j][i] = 0;
	                        }
    	                    else {
    	                        block = map[j][i];
    	                        map[j][i] = 0;
    	                        map[idx][i] = block;
    	                        idx++;
    	                    }
	                    }
	                }
	            }
	            break;
	            
	        case 1:
	            for(int i = 0 ; i < N ; i++) {
	                int idx = N-1;
	                int block = 0;
	                
	                for(int j = N-1 ; j >= 0 ; j--) {
	                    if(map[j][i] != 0) {
    	                    if(block == map[j][i]) {
    	                        map[idx + 1][i] = block * 2;
    	                        block = 0;
    	                        map[j][i] = 0;
    	                    }
    	                    else {
    	                        block = map[j][i];
    	                        map[j][i] = 0;
    	                        map[idx][i] = block;
    	                        idx--;
    	                    }
	                    }
	                }
	            }
	            break;
	            
	        case 2:
	            for(int i = 0 ; i < N ; i++) {
	                int idx = 0;
	                int block = 0;
	                
	                for(int j = 0 ; j < N ; j++) {
	                    if(map[i][j] != 0) {
    	                    if(block == map[i][j]) {
    	                        map[i][idx - 1] = block * 2;
    	                        block = 0;
    	                        map[i][j] = 0;
    	                    }
    	                    else {
    	                        block = map[i][j];
    	                        map[i][j] = 0;
    	                        map[i][idx] = block;
    	                        idx++;
    	                    }
	                    }
	                }
	            }
	            break;
	            
	        case 3:
	            for(int i = 0 ; i < N ; i++) {
	                int idx = N-1;
	                int block = 0;
	                
	                for(int j = N-1 ; j >= 0 ; j--) {
	                    if(map[i][j] != 0) {
    	                    if(block == map[i][j]) {
    	                        map[i][idx + 1] = block * 2;
    	                        block = 0;
    	                        map[i][j] = 0;
    	                    }
    	                    else {
    	                        block = map[i][j];
    	                        map[i][j] = 0;
    	                        map[i][idx] = block;
    	                        idx--;
    	                    }
	                    }
	                }
	            }
	            break;
	    }
	}
	
	private static void findMax() {
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N ; j++) {
	            if(map[i][j] > answer) {
	                answer = map[i][j];
	            }
	        }
	    }
	}
}
