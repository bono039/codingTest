import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    
    static int caseNum;
    static int ans;
    
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력받기
		int cnt = 1;
		while(true) {
    		N = Integer.parseInt(br.readLine().trim());
    		if(N == 0) break;
    		
    		map = new int[N][N];
    		for(int i = 0 ; i < N ; i++) {
    		    st = new StringTokenizer(br.readLine());

    		    for(int j = 0 ; j < N ; j++) {
    		        map[i][j] = Integer.parseInt(st.nextToken().trim());    // 헉스바리
    		    }
    		}
    		
    		ans = Integer.MIN_VALUE;
    		
    		part1();
    		part2();
    		part3();
    		part4();
    		part5();
    		
    		sb.append(cnt +  ". " + ans).append("\n");
    		cnt++;
		}
		
		System.out.println(sb);
	}
	
	// 1번 조각 : 일직선
	private static void part1() {
	    // set에 저장해서 한꺼번에 정렬하는 것도 함 해봐야겠다
	    // 가로 일직선
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N - 3 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
	            ans = Math.max(ans, tmp);
	        }
	    }
	    
	    // 세로 일직선
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j < N - 3 ; j++) {
	            int tmp = map[j][i] + map[j + 1][i] + map[j + 2][i] + map[j + 3][i];
	            ans = Math.max(ans, tmp);
	        }
	    }
	}
	
	// 2번 조각 : ㄱㄴ 모양 (90도 회전)
	private static void part2() {
	    // 정방향
	    for(int i = 0 ; i < N - 1 ; i++) {
	        for(int j = 0 ; j < N - 2 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            ans = Math.max(ans, tmp);
	        }
	    }
	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 2 ; i++) {
	        for(int j = 0 ; j < N - 1 ; j++) {
	            int tmp = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
	            ans = Math.max(ans, tmp);
	        }
	    }
	    // 나머지 두 방향은 중복
	}
	
	// 3번 조각 : ㄱ 권총 모양 (90도 회전)
	private static void part3() {
	    // 정방향
	    for(int i = 0 ; i < N - 1 ; i++) {
	        for(int j = 0 ; j < N - 2 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
	            ans = Math.max(ans, tmp);
	        }
	    }
	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 2 ; i++) {
	        for(int j = 0 ; j < N - 1 ; j++) {
	            int tmp = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j];
	            ans = Math.max(ans, tmp);
	        }
	    }
	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 1 ; i++) {
	        for(int j = 0 ; j < N - 2 ; j++) {
	            int tmp = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            ans = Math.max(ans, tmp);
	        }
	    }
	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 2 ; i++) {
	        for(int j = 0 ; j < N - 1 ; j++) {
	            int tmp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1];
	            ans = Math.max(ans, tmp);
	        }
	    }	    
	}
	
	// 4번 조각 : 법큐 모양 (90도 회전)
	private static void part4() {
	    // 정방향
	    for(int i = 0 ; i < N - 1 ; i++) {
	        for(int j = 0 ; j < N - 2 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i][j + 2];
	            ans = Math.max(ans, tmp);
	        }
	    }	    
	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 2 ; i++) {
	        for(int j = 0 ; j < N - 1 ; j++) {
	            int tmp = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
	            ans = Math.max(ans, tmp);
	        }
	    }	    
	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 1 ; i++) {
	        for(int j = 0 ; j < N - 2 ; j++) {
	            int tmp = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            ans = Math.max(ans, tmp);
	        }
	    }	    
	    // 시계 방향 90도 회전
	    for(int i = 0 ; i < N - 2 ; i++) {
	        for(int j = 0 ; j < N - 1 ; j++) {
	            int tmp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
	            ans = Math.max(ans, tmp);
	        }
	    }
	}
	
	// 5번 조각 : 정사각형
	private static void part5() {
	    for(int i = 0 ; i < N - 1 ; i++) {
	        for(int j = 0 ; j < N - 1 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
	            ans = Math.max(ans, tmp);
	        }
	    }
	}
	
}
