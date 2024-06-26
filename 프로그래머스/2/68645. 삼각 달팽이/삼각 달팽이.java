import java.util.*;

class Solution {
    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,-1};
    
    static int n;
    static int[][] arr;
    
    public int[] solution(int n) {
        this.n = n;
                
        arr = new int[n][n];
        int len = (n*(n+1))/2;
        
        int num = 1;
        int x = 0;
        int y = 0;
        int dir = 0;
        arr[x][y] = num;
        
        while(num < len) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!inRange(nx, ny) || arr[nx][ny] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            if(inRange(nx, ny) && arr[nx][ny] == 0) {
                arr[nx][ny] = ++num;
                x = nx;
                y = ny;
            }
        }
        
        int[] answer = new int[len];
        int idx = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] != 0) {
                    answer[idx++] = arr[i][j];
                }
            }
        }
        
        return answer;
    }
    
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}