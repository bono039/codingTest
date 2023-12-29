import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    
    static int blackCnt, whiteCnt;
    
    static List<int[]> bList = new ArrayList<>();
    static List<int[]> wList = new ArrayList<>();
    
    static int blackScore, whiteScore;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    board = new int[20][20];
	    visited = new boolean[20][20];
	    
	    for(int i = 1 ; i <= 19 ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 1 ; j <= 19 ; j++) {
	            board[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i = 1 ; i <= 19 ; i++) {
	        for(int j = 1 ; j <= 19 ; j++) {
	            if(board[i][j] == 0)    continue;
	            
	            rCheck(i, j);
	            cCheck(i, j);
	            lrCheck(i, j);
	            rlCheck(i, j);
	        }
	    }
	    
	    // 검은돌 리스트와 흰돌리스트 정렬
	    // 가장 왼쪽 위에 있는 값으로
	    Collections.sort(bList, new Comparator<int[]>() {
	        @Override
	        public int compare(int[] o1, int[] o2) {
	            if(o1[0] != o2[0])
	                return o1[0] - o2[0];
	            return o1[1] - o2[1];
	        }
	    });
	    
	   Collections.sort(wList, new Comparator<int[]>() {
	       @Override 
	       public int compare(int[] o1, int[] o2) {
	           if(o1[0] != o2[0])
	                return o1[0] - o2[0];
	           return o1[1] - o2[1];
	       }
	   });
	    
	    if(blackScore > whiteScore) {
	        System.out.println(1);
	        System.out.println(bList.get(0)[0] + " " + bList.get(0)[1]);
	    }
	    else if(blackScore < whiteScore) {
	        System.out.println(2);
	        System.out.println(wList.get(0)[0] + " " + wList.get(0)[1]);
	    }
	    else {
	        System.out.println(0);
	    }
	}
	
	private static void rCheck(int i, int j) {
        int tmp = board[i][j];
        
        if(tmp == 0 || !inRange(i, j + 4))    return;
        
        if((board[i][j] == board[i][j + 1]) && (board[i][j + 1] == board[i][j + 2]) && (board[i][j + 2] == board[i][j + 3]) && (board[i][j + 3] == board[i][j + 4])) {
            if(inRange(i, j - 1) && board[i][j] == board[i][j - 1]) return;
            if(inRange(i, j + 5) && board[i][j] == board[i][j + 5]) return;
            
            if(tmp == 1) {
                bList.add(new int[] {i, j});
                blackScore++;
            }
            else if(tmp == 2) {
                wList.add(new int[] {i, j});
                whiteScore++;
            }
        }
	}
	
	private static void cCheck(int i, int j) {
        int tmp = board[i][j];
        
        if(tmp == 0 || !inRange(i + 4, j))    return;
        
        if((board[i][j] == board[i + 1][j]) && (board[i + 1][j] == board[i + 2][j]) && (board[i + 2][j] == board[i + 3][j]) && (board[i + 3][j] == board[i + 4][j])) {
            if(inRange(i - 1, j) && board[i][j] == board[i - 1][j]) return;
            if(inRange(i + 5, j) && board[i][j] == board[i + 5][j]) return;
            
            if(tmp == 1) {
                bList.add(new int[] {i, j});
                blackScore++;
            }
            else if(tmp == 2) {
                wList.add(new int[] {i, j});
                whiteScore++;
            }
        }
    }
	
	private static void lrCheck(int i, int j) {
        int tmp = board[i][j];
        
        if(tmp == 0 || !inRange(i + 4, j + 4))    return;
        
        if((board[i][j] == board[i + 1][j + 1]) && (board[i + 1][j + 1] == board[i + 2][j + 2]) && (board[i + 2][j + 2] == board[i + 3][j + 3]) && (board[i + 3][j + 3] == board[i + 4][j + 4])) {
            if(inRange(i - 1, j - 1) && board[i][j] == board[i - 1][j - 1]) return;
            if(inRange(i + 5, j + 5) && board[i][j] == board[i + 5][j + 5]) return;
            
            if(tmp == 1) {
                bList.add(new int[] {i, j});
                blackScore++;
            }
            else if(tmp == 2) {
                wList.add(new int[] {i, j});
                whiteScore++;
            }
        }
	}
	
	private static void rlCheck(int i, int j) {
        int tmp = board[i][j];
        
        if(tmp == 0 || !inRange(i + 4, j - 4))    return;
        
        if((board[i][j] == board[i + 1][j - 1]) && (board[i + 1][j - 1] == board[i + 2][j - 2]) && (board[i + 2][j - 2] == board[i + 3][j - 3]) && (board[i + 3][j - 3] == board[i + 4][j - 4])) {
            if(inRange(i - 1, j + 1) && board[i][j] == board[i - 1][j + 1]) return;
            if(inRange(i + 5, j - 5) && board[i][j] == board[i + 5][j - 5]) return;
            
            if(tmp == 1) {
                bList.add(new int[] {i + 4, j - 4});
                blackScore++;
            }
            else if(tmp == 2) {
                wList.add(new int[] {i + 4, j - 4});
                whiteScore++;
            }
        }
	}	
	private static boolean inRange(int r, int c) {
	    return (1 <= r && r <= 19 && 1 <= c && c <= 19);
	}
}
