import java.util.*;
import java.io.*;

class Solution {
    static int cnt = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {  // 현재 피로도,  [최소 필요 피로도, 소모 피로도]
        visited = new boolean[dungeons.length];
        
        back(0, k, dungeons);
        
        return cnt;
    }
    
    private static void back(int depth, int k, int[][] arr) {
        for(int i = 0 ; i < arr.length ; i++) {
            if(!visited[i] && arr[i][0] <= k) {
                visited[i] = true;
                back(depth + 1, k - arr[i][1], arr);
                visited[i] = false;
            }
        }
        
        cnt = Math.max(cnt, depth);
    }
}