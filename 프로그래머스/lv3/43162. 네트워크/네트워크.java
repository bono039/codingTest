import java.util.*;
import java.io.*;

class Solution {
    static int n, answer;
    static int[][] computers;
    
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        // 멤버 변수 선언
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n];
        answer = 0;
        
        // 방문하지 않은 각 점에 대해 BFS 수행
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                bfs(i, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int num, int n) {
        visited[num] = true;
        q.add(num);
        
        while(!q.isEmpty()) {
            int now = q.poll();
                
            for(int i = 0 ; i < n ; i++) {
                if(!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}