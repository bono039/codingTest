import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};    // 위 왼쪽 오른쪽 아래
    static int[] dy = {0, 0, -1, 1};
    
    static int N;
    static int[][] arr, ans;
    
    static int result = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N * N + 1][5];
		
		for(int i = 1 ; i <= N * N ; i++) {
		    String[] str = br.readLine().split(" ");
		    
		    arr[i][0] = Integer.parseInt(str[0]);  // 첫 번째 숫자 : 학생 번호
		    
		    // 나머지 숫자 4개 : 좋아하는 학생 기록
		    for(int j = 1 ; j < 5 ; j++) {
		        arr[i][j] = Integer.parseInt(str[j]);
		    }
		}
		
		// 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸
		// 2. 1을 만족하는 칸이 여러개면, 인접한 칸 중 비어있는 칸이 가장 많은 칸
		// 3. 2를 만족하는 칸도 여러개면, 행의 번호가 가장 작은 칸 > 열의 번호가 가장 작은 칸
		
		
		// 자리 배치 채우기
		ans = new int[N + 1][N + 1];
		
		for(int i = 1 ; i <= N * N ; i++) {
		    int num = arr[i][0];
		    
            int[] pos = {N, N};
            int aroundCnt = 0;
            int emptyCnt = 0;
		    
		    // 배열의 올바른 위치 탐색해
		    for(int a = 1 ; a <= N ; a++) {
		        for(int b = 1 ; b <= N ; b++) {
		            if(ans[a][b] != 0)  continue;
		            
		            // 조건1.비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸
		            if(aroundLike(num, a, b) != aroundCnt) {
		                if(aroundLike(num, a, b) > aroundCnt) {
		                    pos = new int[] {a, b};
		                    aroundCnt = aroundLike(num, a, b);
		                    emptyCnt = aroundEmpty(num, a, b);
		                }
		            }
		            else {
		                // 조건2 인접한 칸 중 비어있는 칸이 가장 많은 칸
		                if(aroundEmpty(num, a, b) != emptyCnt) {
		                    if(aroundEmpty(num, a, b) > emptyCnt) {
		                        pos = new int[] {a, b};
		                        emptyCnt = aroundEmpty(num, a, b);
		                    }
		                }
		                else {
		                    // 조건3 행의 번호가 가장 작은 칸 > 열의 번호가 가장 작은 칸
		                    if(a < pos[0] || (a == pos[0] && b < pos[1])) {
                                pos = new int[] {a, b};
                            }
		                }
		            }
		        }
		    }
		    
		    ans[pos[0]][pos[1]] = num;
		}
		
		// 학생 만족도 구하기
		for(int i = 1 ; i <= N * N ; i++) {
		    int num = arr[i][0];    // 해당 학생
		    
		    // num의 자리 찾기
		    int[] pos = new int[2];
		    
		    for(int a = 1 ; a <= N ; a++) {
		        for(int b = 1 ; b <= N ; b++) {
		            if(ans[a][b] == num) {
		                pos = new int[] {a, b};
		                break;
		            }
		        }
		    }
		    
		    // 해당 학생(num) 주변의 좋아하는 학생 수 구하기
		    addResult(aroundLike(num, pos[0], pos[1]));
		}
		
		System.out.println(result);
	}
	
	// 인접 칸에서 좋아하는 학생 수 세는 메소드
	private static int aroundLike(int num, int r, int c) {
	    int cnt = 0;
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        int nr = r + dx[d];
	        int nc = c + dy[d];
	        
	        if(!inRange(nr, nc))    continue;
	        
	        // ans[nx][ny]가 num이 좋아하는 학생인지 판별
	        if(like(num, ans[nr][nc])) {
	            cnt++;
	        }
	    }
	    
	    return cnt;
	}
	
	private static int aroundEmpty(int num, int r, int c) {
	    int cnt = 0;
	    
	    for(int d = 0 ; d < 4 ; d++) {
	        int nr = r + dx[d];
	        int nc = c + dy[d];
	        
	        if(!inRange(nr, nc))    continue;
	        
	        // 인접한 칸이 빈 칸인지 판별
	        if(ans[nr][nc] == 0) {
	            cnt++;
	        }
	    }
	    
	    return cnt;	    
	}
	
	private static boolean inRange(int r, int c) {
	    return (1 <= r && r <= N && 1 <= c && c <= N);
	}
	
	private static boolean like(int num, int findNum) {
	    for(int i = 1 ; i <= N * N ; i++) {
	        if(arr[i][0] == num) {
	            for(int j = 1 ; j < 5 ; j++) {
	                if(arr[i][j] == findNum) {
	                    return true;
	                }
	            }
	        }
	    }
	    
	    return false;
	}
	
	private static void addResult(int cnt) {
	    result += Math.pow(10, cnt - 1);
	}
}
