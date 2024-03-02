import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};    // 아래-왼-위-오른쪽
    static int[] dy = {0, -1, 0, 1};
    
    static String[] grid;
    static int r, c;
    static boolean[][][] visited;
    
    static List<Integer> ans = new ArrayList<>();
    
    public int[] solution(String[] grid) {
        this.grid = grid;
        
        r = grid.length;
        c = grid[0].length();
        visited = new boolean[r][c][4];
        
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                for(int d = 0 ; d < 4 ; d++) {
                    if(!visited[i][j][d])
                        ans.add(light(i, j, d));
                }
            }
        }
        Collections.sort(ans);
        
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < answer.length ; i++)
            answer[i] = ans.get(i);
        return answer;
    }
    
    private static int light(int i, int j, int d) {
        int cnt = 0;
        
        while(!visited[i][j][d]) {
            cnt++;
            visited[i][j][d] = true;
            
            if(grid[i].charAt(j) == 'L')
                d = (d+3) % 4;  // 좌회전
            if(grid[i].charAt(j) == 'R')
                d = (d+1) % 4;  // 우회전
            
            i = (i + dx[d] + r) % r;
            j = (j + dy[d] + c) % c;
        }
        
        return cnt;
    }
}