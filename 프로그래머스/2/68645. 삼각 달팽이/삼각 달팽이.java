import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1}; // 남 -> 동 -> 북서 (행렬 기준)
    static int[] dy = {0, 1, -1};
    
    static int n;
    static int[][] map;
    
    public int[] solution(int n) {
        this.n = n;
        map = new int[n + 1][n + 1];
        map[0][0] = 1;
        
        int num = 1;
        int x = 0;
        int y = 0;
        int dir = 0;
        
        for(int i = 2 ; i <= n * n ; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 방문한 적 없고, 범위를 벗어나지 않을 때만 이동 가능
            if(map[nx][ny] == 0 && inRange(nx, ny)) {
                x = nx;
                y = ny;
                map[x][y] = ++num;
            }
            else {
                dir = (dir + 1) % 3;
            }
        }  
        
        
        List<Integer> list = new ArrayList<>();
        for(int[] i : map) {
            for(int j : i) {
                if(j != 0) {
                    list.add(j);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}